package com.exam.imageapplication

import retrofit2.Call
import retrofit2.http.GET

interface APICall {

    @GET("breeds/image/random")
    fun getData(): Call<DataResponse?>?
}