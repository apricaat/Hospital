package com.example.hospital.navigation

import com.github.terrakok.cicerone.Cicerone

class NavigationCore : NavigationApi {

    override val cicerone = Cicerone.create()
    override val router = cicerone.router
    override val holder = cicerone.getNavigatorHolder()

}