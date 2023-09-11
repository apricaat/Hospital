package com.example.hospital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospital.features.mainFragment.ui.MainFragment
import com.example.hospital.navigation.NavigationApi
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val cicerone : NavigationApi by inject()

    private val navigator by lazy {
        AppNavigator(this, R.id.fragment_container_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        cicerone.holder.setNavigator(navigator)
        cicerone.router.navigateTo(MainFragment.screenMain)
    }

    override fun onPause() {
        cicerone.holder.removeNavigator()
        super.onPause()
    }
}