package org.sairaa.rightly.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dqn.R
import org.sairaa.rightly.database.dao.SampleDao
import org.sairaa.rightly.database.db.AppDb
import org.sairaa.rightly.network.api.SampleApi
import org.sairaa.rightly.repository.SampleRepository
import org.sairaa.rightly.repository.SampleRepositoryImpl
import org.sairaa.rightly.viewModels.SampleViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    fun provideSampleApi(retrofit: Retrofit): SampleApi {
        return retrofit.create(SampleApi::class.java)
    }
    single { provideSampleApi(get()) }
}

val networkModule = module {
    fun provideHttpClient():OkHttpClient{
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(40,TimeUnit.SECONDS)
            .readTimeout(40,TimeUnit.SECONDS)

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client:OkHttpClient,baseUrl:String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { provideHttpClient() }
    single {
        val baseUrl = androidContext().getString(R.string.baseUrl)
        provideRetrofit(get(),baseUrl)
    }
}

val databaseModule = module {
    fun provideDatabase(application: Application): AppDb {
        return Room.databaseBuilder(application,
            AppDb::class.java,"sample_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideSampleDao(database: AppDb): SampleDao {
        return database.sampleDao
    }

    single { provideDatabase(androidApplication()) }

    single { provideSampleDao(get()) }
}

val repositoryModule = module {
    fun provideRepository(api: SampleApi, context: Context, dao: SampleDao): SampleRepositoryImpl {
        return SampleRepositoryImpl(api, context, dao)
    }

    single<SampleRepository>(named("repository")) { provideRepository(get(),androidContext(),get()) }
}

val viewModelModules = module {
    viewModel {
        SampleViewModel(get(named("repository")))
    }
}