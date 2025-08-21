package com.example.dailynews

import android.app.Application
import com.example.dailynews.di.sharedKoinModules
import com.example.dailynews.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
  The Application class is the first class instantiated when our Android
  application is opened. This class is a singleton, so only a single
  instance can be created.

  Furthermore, this class stays alive until the user kills the application
  process. We can use this class for many reasons, such as storing global
  data or session information.

  For now, we are just going to use it to initialize dependency injection.
*/
class DailyNewsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@DailyNewsApp)
            modules(modules)
        }
    }
}