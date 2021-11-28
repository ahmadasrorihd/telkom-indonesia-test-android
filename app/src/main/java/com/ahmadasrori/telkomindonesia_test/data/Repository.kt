package com.ahmadasrori.telkomindonesia_test.data

import com.ahmadasrori.telkomindonesia_test.model.DetailResponse
import com.ahmadasrori.telkomindonesia_test.remote.Api
import io.reactivex.Observable

class Repository(val api: Api) {

    fun getTopStory(): Observable<List<String>> {
        return api.getTopStory()
    }

    fun getDetailStory(storyId: String): Observable<DetailResponse> {
        return api.getDetailStory(storyId)
    }

}