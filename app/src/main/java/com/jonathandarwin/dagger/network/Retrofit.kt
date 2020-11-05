package com.jonathandarwin.dagger.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        val service = Retrofit.Builder()
                        .baseUrl("https://reqres.in")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build()
                        .create(WebService::class.java)
    }
}