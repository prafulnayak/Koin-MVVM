package com.example.dqn

import android.app.Application
import com.example.dqn.di.*
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {

            androidContext(this@MyApp)

            modules(
                appModule,
                apiModule,
                networkModule,
                databaseModule,
                repositoryModule,
                viewModelModules,
                viewModelModule
            )
        }
    }


}