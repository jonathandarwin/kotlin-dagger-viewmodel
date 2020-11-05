package com.jonathandarwin.dagger.di.module.viewmodel.main

import androidx.lifecycle.ViewModel
import com.jonathandarwin.dagger.di.module.viewmodel.ViewModelKey
import com.jonathandarwin.dagger.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class) // To what are the dependencies in this ViewModel
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel
}