package com.jonathandarwin.dagger.di.module

import com.jonathandarwin.dagger.network.Retrofit
import com.jonathandarwin.dagger.network.WebService
import dagger.Module
import dagger.Provides

@Module
class NetworkModule{

    // Tell Dagger how to create a WebService instance
    @Provides
    fun provideWebService() : WebService = Retrofit.service
}