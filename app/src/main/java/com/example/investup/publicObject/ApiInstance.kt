package com.example.investup.publicObject

import com.example.investup.retrofit.UserApi
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiInstance {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)

        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://45.9.43.5:5000/")
        .addConverterFactory(GsonConverterFactory.create())
       .client(okHttpClient)
        .build()


    private val userApi = retrofit.create(UserApi::class.java)
    fun getApi(): UserApi {
        return userApi
    }
}