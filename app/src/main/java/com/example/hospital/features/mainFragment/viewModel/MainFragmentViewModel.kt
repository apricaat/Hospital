package com.example.hospital.features.mainFragment.viewModel

import com.example.hospital.base.BaseViewModel
import com.example.hospital.database.patientDataBase.PatientDAO
import com.example.hospital.features.departmentFragment.ui.DepartmentFragment
import com.example.hospital.features.patientFragment.ui.PatientFragment
import com.example.hospital.navigation.NavigationApi
import com.example.hospital.utils.department.Departments

class MainFragmentViewModel(
    private val patientDAO: PatientDAO,
    private val navigationApi: NavigationApi
) : BaseViewModel() {

    fun routeTo(department: Departments? = null) {
        navigationApi.router.navigateTo(DepartmentFragment.getInstance(department))
    }

    fun routeToAddNewPatient() {
        navigationApi.router.navigateTo(PatientFragment.getInstance())
    }
}