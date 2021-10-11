package com.tejas.koindemo

import android.app.Application
import com.tejas.koindemo.di.apiModule
import com.tejas.koindemo.di.repositoryModule
import com.tejas.koindemo.di.retrofitModule
import com.tejas.koindemo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(repositoryModule,viewModelModule,retrofitModule,apiModule))
        }
    }

}