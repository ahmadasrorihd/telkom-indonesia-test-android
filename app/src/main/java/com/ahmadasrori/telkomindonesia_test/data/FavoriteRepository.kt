package com.ahmadasrori.telkomindonesia_test.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.ahmadasrori.telkomindonesia_test.db.FavoriteDao
import com.ahmadasrori.telkomindonesia_test.db.FavoriteRoomDatabase
import com.ahmadasrori.telkomindonesia_test.model.Story
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteRepository(application: Application) {
    private val fav: FavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FavoriteRoomDatabase.getDatabase(application)
        fav = db.favDao()
    }

    fun getFav(login: String): LiveData<Story> = fav.getFav(login)

    fun getAllFav(): LiveData<List<Story>> = fav.getAllFav()

    fun insert(favorite: Story) {
        executorService.execute { fav.insert(favorite) }
    }

    fun delete(login: String) {
        executorService.execute { fav.delete(login) }
    }

}