package com.ahmadasrori.telkomindonesia_test.di

import com.ahmadasrori.telkomindonesia_test.viewmodel.FavoriteViewModel
import com.ahmadasrori.telkomindonesia_test.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }

    viewModel {
        FavoriteViewModel(get())
    }

}