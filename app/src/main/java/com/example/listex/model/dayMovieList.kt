package com.example.listex.model

import com.google.gson.annotations.SerializedName

data class dayMovieList(
    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList: List<dayMovieInfo> = arrayListOf()
    //받아온 결과를 MovieDto list 형태로 만든다.
)
