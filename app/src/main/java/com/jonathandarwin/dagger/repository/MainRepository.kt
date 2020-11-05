package com.jonathandarwin.dagger.repository

import com.jonathandarwin.dagger.dto.UserResponse
import com.jonathandarwin.dagger.network.WebService
import io.reactivex.rxjava3.core.Observable
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

class MainRepository @Inject constructor(private val webService: WebService) : IMainRepository {

    override fun getUser(): Observable<Result<*>> {
        return webService.getUser().flatMap{
            if(it == null)
                Observable.just(Result.failure<Exception>(Exception("Error. Please try again")))
            else
                Observable.just(Result.success(it))
        }
    }
}