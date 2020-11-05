package com.jonathandarwin.dagger.di.component

import com.jonathandarwin.dagger.di.module.NetworkModule
import com.jonathandarwin.dagger.di.module.RepositoryModule
import com.jonathandarwin.dagger.di.module.ViewModelFactoryModule
import com.jonathandarwin.dagger.di.module.viewmodel.main.MainViewModelModule
import com.jonathandarwin.dagger.ui.MainActivity
import dagger.Component

@Component(
    // Specify what module that involved in this component
    modules = [RepositoryModule::class, NetworkModule::class, ViewModelFactoryModule::class, MainViewModelModule::class]
)
interface ApplicationComponent{

    // Start point of the graph, Dagger will inject all the dependency in MainActivity by its own
    // If you have another activity, you also need to add the interface function for that activity
    fun inject(activity : MainActivity)
}