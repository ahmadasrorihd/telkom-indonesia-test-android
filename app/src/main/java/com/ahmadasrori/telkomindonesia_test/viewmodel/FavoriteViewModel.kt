package com.ahmadasrori.telkomindonesia_test.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahmadasrori.telkomindonesia_test.data.FavoriteRepository
import com.ahmadasrori.telkomindonesia_test.model.Story

class FavoriteViewModel(application: Application) : ViewModel() {

    private val favoriteRepository: FavoriteRepository = FavoriteRepository(application)

    fun insert(fav: Story) {
        favoriteRepository.insert(fav)
    }

    fun delete(login: String) {
        favoriteRepository.delete(login)
    }

    fun getFav(login: String): LiveData<Story> = favoriteRepository.getFav(login)

    fun getAllFav(): LiveData<List<Story>> = favoriteRepository.getAllFav()

}