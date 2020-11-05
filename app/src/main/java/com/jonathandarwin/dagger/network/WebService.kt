package com.jonathandarwin.dagger.network

import com.jonathandarwin.dagger.dto.UserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface WebService{
    @GET("/api/users")
    fun getUser() : Observable<UserResponse>
}