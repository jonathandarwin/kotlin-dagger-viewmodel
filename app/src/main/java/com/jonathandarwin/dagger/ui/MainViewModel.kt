package com.jonathandarwin.dagger.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonathandarwin.dagger.model.User
import com.jonathandarwin.dagger.usecase.MainUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : ViewModel(){

    fun getUser() : LiveData<List<User>> {
        val user = MutableLiveData<List<User>>()
        mainUseCase.getUser()
            .subscribe({
                user.postValue(it)
            }, {
                user.postValue(null)
            })
        return user
    }
}