package com.example.hospital.navigation

import org.koin.dsl.module

object NavigationModule {

    val navigationModule = module(createdAtStart = true) {
        single<NavigationApi> { NavigationCore() }
    }
}