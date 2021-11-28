package com.ahmadasrori.telkomindonesia_test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmadasrori.telkomindonesia_test.data.Repository
import com.ahmadasrori.telkomindonesia_test.model.DetailResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: Repository) : ViewModel() {

    val topStory = MutableLiveData<List<String>>()
    val detailStory = MutableLiveData<DetailResponse>()
    val apiResponse = MutableLiveData<String>()

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun getTopStory() {
        compositeDisposable.add(
            repository.getTopStory()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    val response = it
                    topStory.postValue(response)
                }, {
                    apiResponse.postValue(it.message)
                })
        )
    }

    fun getDetailStory(storyId: String) {
        compositeDisposable.add(
            repository.getDetailStory(storyId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    val response = it
                    detailStory.postValue(response)
                }, {
                    apiResponse.postValue(it.message)
                })
        )
    }

}