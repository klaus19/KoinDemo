package com.tejas.koindemo.di

import com.tejas.koindemo.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        UserRepository(get())
    }
}