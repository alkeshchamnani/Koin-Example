package com.alkesh.koinexample.common.di.module

import com.alkesh.koinexample.common.constant.AppConstants
import org.koin.dsl.module

val appModule = module {
    single {
        AppConstants()
    }
}