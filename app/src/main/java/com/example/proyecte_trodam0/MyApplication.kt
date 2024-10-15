package com.example.proyecte_trodam0

import android.app.Application
import com.example.proyecto_trodam0.QuizViewModel
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}

// Módulo donde declares el ViewModel
val appModule = module {
    single { QuizViewModel() }
}
