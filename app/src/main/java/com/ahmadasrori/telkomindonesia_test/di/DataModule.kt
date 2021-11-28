package com.ahmadasrori.telkomindonesia_test.di

import com.ahmadasrori.telkomindonesia_test.data.Repository
import com.ahmadasrori.telkomindonesia_test.remote.RetrofitClient
import org.koin.dsl.module

val dataModule = module {
    single {
        RetrofitClient.instance
    }
    factory {
        Repository(get())
    }
}