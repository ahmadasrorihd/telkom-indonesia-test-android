package com.ahmadasrori.telkomindonesia_test.remote

import com.ahmadasrori.telkomindonesia_test.model.DetailResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("topstories.json?print=pretty")
    fun getTopStory(
    ): Observable<List<String>>

    @GET("item/{story_id}.json?print=pretty")
    fun getDetailStory(
        @Path("story_id") storyId: String
    ): Observable<DetailResponse>

}
