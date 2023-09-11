package com.example.hospital.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface NavigationApi {

    val cicerone: Cicerone<Router>
    val router: Router
    val holder: NavigatorHolder
}