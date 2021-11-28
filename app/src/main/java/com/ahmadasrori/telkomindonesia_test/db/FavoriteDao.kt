package com.ahmadasrori.telkomindonesia_test.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmadasrori.telkomindonesia_test.model.Story

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(fav: Story)

    @Query("DELETE from Story WHERE storyId= :storyId")
    fun delete(storyId: String)

    @Query("SELECT * from Story WHERE storyId= :storyId")
    fun getFav(storyId: String): LiveData<Story>

    @Query("SELECT * from Story ORDER BY id ASC")
    fun getAllFav(): LiveData<List<Story>>
}