package com.example.hospital.features.patientFragment.koin

import com.example.hospital.features.patientFragment.viewModel.PatientFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PatientFragmentModule {

    val patientFragmentModule = module {
        viewModel { PatientFragmentViewModel(get()) }
    }
}