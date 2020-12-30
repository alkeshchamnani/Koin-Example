package com.alkesh.koinexample.common.di.module

import com.alkesh.koinexample.core.repository.TaskRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        TaskRepository(get())
    }
}