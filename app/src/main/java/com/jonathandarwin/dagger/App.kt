package com.jonathandarwin.dagger

import android.app.Application
import com.jonathandarwin.dagger.di.component.ApplicationComponent
import com.jonathandarwin.dagger.di.component.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        // First, create the graph when app is open, similar to startKoin in Koin
        applicationComponent = DaggerApplicationComponent.create()
    }
}