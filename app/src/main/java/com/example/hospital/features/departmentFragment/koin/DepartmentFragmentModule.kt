package com.example.hospital.features.departmentFragment.koin

import com.example.hospital.features.departmentFragment.viewModel.DepartmentFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DepartmentFragmentModule {

    val departmentFragmentModule = module {
        viewModel { DepartmentFragmentViewModel(get(), get()) }
    }
}