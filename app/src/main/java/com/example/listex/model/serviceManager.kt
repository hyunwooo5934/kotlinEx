package com.example.listex.model

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class serviceManager {

    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.kobis.or.kr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}