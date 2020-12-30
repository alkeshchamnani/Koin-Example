package com.alkesh.koinexample.common.base.application

import android.app.Application
import com.alkesh.koinexample.common.di.module.appModule
import com.alkesh.koinexample.common.di.module.repositoryModule
import com.alkesh.koinexample.common.di.module.retrofitModule
import com.alkesh.koinexample.common.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(appModule, retrofitModule, repositoryModule,viewModelModule))
        }
    }
}