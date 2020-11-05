package com.jonathandarwin.dagger.di.module

import androidx.lifecycle.ViewModelProvider
import com.jonathandarwin.dagger.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    // Basically provide the instance of Factory, it will be injected in the activity
    @Binds
    abstract fun bindViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory
}