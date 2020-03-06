package com.exam.imageapplication

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetforitAPI {

    val BASE_URL:String = "https://dog.ceo/api/"

    val getClient: APICall
        get() {

            val gson = GsonBuilder()
                .setLenient()
                .create()
            val client = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(APICall::class.java)

        }

}