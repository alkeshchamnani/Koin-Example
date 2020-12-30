package com.alkesh.koinexample.common.di.module

import com.alkesh.koinexample.presentation.screen.todo.viewmodel.ListTaskViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel() {
        ListTaskViewModel(get())
    }
}