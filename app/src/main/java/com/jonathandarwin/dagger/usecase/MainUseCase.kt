package com.jonathandarwin.dagger.usecase

import com.jonathandarwin.dagger.dto.UserResponse
import com.jonathandarwin.dagger.model.User
import com.jonathandarwin.dagger.repository.IMainRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Exception
import javax.inject.Inject

// This is how to inject a constructor
class MainUseCase @Inject constructor(private val mainRepository: IMainRepository) {

    fun getUser() : Observable<List<User>> {
        return mainRepository.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .flatMap {
                if(it.isSuccess){
                    val result = mutableListOf<User>()
                    (it.getOrNull() as UserResponse).data.forEach{
                        item -> result.add(User(item.email, item.first_name, item.last_name))
                    }
                    Observable.just(result)
                }
                else{
                    throw it.exceptionOrNull() ?: Exception("Error. Please try again.")
                }
            }
    }
}