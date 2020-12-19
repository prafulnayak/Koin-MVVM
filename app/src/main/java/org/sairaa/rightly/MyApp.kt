package org.sairaa.rightly

import android.app.Application
import org.sairaa.rightly.di.*
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