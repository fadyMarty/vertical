package com.verticalautomotive.android

import android.app.Application
import com.verticalautomotive.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VerticalAutomotiveApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VerticalAutomotiveApp)
            modules(appModule)
        }
    }
}