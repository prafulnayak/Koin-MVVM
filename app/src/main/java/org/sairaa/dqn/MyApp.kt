package org.sairaa.dqn

import android.app.Application
import org.sairaa.dqn.di.*
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