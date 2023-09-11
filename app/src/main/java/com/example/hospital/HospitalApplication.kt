package com.example.hospital

import android.app.Application
import android.content.Context
import com.example.hospital.dependencyInjectionCore.Keys
import com.example.hospital.dependencyInjectionCore.KoinCoreModules
import com.example.hospital.dependencyInjectionCore.setKey
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class HospitalApplication: Application() {

    private val applicationModule = module {
        single<Context>(setKey(Keys.APPLICATION_CONTEXT)) {
            this@HospitalApplication.applicationContext
        }
    }
    private val modules: ArrayList<Module> = KoinCoreModules.modules.also {
        it.add(applicationModule)
    }

    override fun onCreate() {
        super.onCreate()

        var t = ""
        startKoin {
            androidLogger()
            androidContext(this@HospitalApplication)
            modules(modules)
        }
    }
}