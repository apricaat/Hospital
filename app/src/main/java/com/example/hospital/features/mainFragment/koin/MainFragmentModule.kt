package com.example.hospital.features.mainFragment.koin

import com.example.hospital.features.mainFragment.viewModel.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainFragmentModule {

    val mainFragmentModule = module {
        viewModel { MainFragmentViewModel(get(), get()) }
    }
}