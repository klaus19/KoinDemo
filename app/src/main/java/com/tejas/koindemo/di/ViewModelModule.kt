package com.tejas.koindemo.di

import com.tejas.koindemo.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        UserViewModel(get())
    }
}