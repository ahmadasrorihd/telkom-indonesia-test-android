package com.ahmadasrori

import android.app.Application
import com.ahmadasrori.telkomindonesia_test.di.dataModule
import com.ahmadasrori.telkomindonesia_test.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppController : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppController)
            modules(dataModule)
            modules(viewModelModule)
        }
    }


}