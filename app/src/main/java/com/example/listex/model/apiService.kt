package com.example.listex.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface apiService {

    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    fun dayMoviveInfoData(@Query("key") key :String,
                          @Query("targetDt") targetDt : String)
    : Call<dayMovieResponse>

}