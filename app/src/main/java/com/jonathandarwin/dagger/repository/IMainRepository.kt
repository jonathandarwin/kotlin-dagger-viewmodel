package com.jonathandarwin.dagger.repository

import com.jonathandarwin.dagger.dto.UserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface IMainRepository{
    fun getUser() : Observable<Result<*>>
}