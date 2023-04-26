package com.example.listex.model

import com.google.gson.annotations.SerializedName

data class dayMovieResponse(
    @SerializedName("boxOfficeResult")
    var boxofficeResult: dayMovieList?
)
