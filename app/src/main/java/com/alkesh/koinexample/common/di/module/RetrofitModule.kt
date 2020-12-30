package com.alkesh.koinexample.common.di.module

import com.alkesh.koinexample.common.network.retrofitService.RetrofitService
import org.koin.dsl.module

val retrofitModule = module {
    single {
        RetrofitService(get()).getInstance()
    }
}