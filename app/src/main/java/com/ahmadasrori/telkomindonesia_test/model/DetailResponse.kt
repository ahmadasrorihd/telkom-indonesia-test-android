package com.ahmadasrori.telkomindonesia_test.model

import com.google.gson.annotations.SerializedName

data class DetailResponse(

	@field:SerializedName("score")
	val score: Int? = null,

	@field:SerializedName("by")
	val by: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("time")
	val time: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("descendants")
	val descendants: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("kids")
	val kids: List<Int?>? = null
)
