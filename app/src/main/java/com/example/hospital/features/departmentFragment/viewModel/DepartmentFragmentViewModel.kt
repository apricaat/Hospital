package com.example.hospital.features.departmentFragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hospital.base.BaseViewModel
import com.example.hospital.database.patientDataBase.Patient
import com.example.hospital.database.patientDataBase.PatientDAO
import com.example.hospital.features.patientFragment.ui.PatientFragment
import com.example.hospital.navigation.NavigationApi
import com.example.hospital.utils.department.Departments
import kotlinx.coroutines.launch

class DepartmentFragmentViewModel(
    private val patientDAO: PatientDAO,
    private val navigationApi: NavigationApi
) : BaseViewModel() {

    private val _patientListLiveData: MutableLiveData<ArrayList<Patient>> = MutableLiveData()
    val patientListLiveData: LiveData<ArrayList<Patient>> = _patientListLiveData

    fun onInit(department: Departments? = null) = launch {
        when (department) {
            Departments.SURGERY -> { getArrayListPatients(patientDAO.getPatientsFromDepartment("Хирургия")) }
            Departments.THERAPY -> { getArrayListPatients(patientDAO.getPatientsFromDepartment("Терапия")) }
            Departments.CARDIOLOGY -> { getArrayListPatients(patientDAO.getPatientsFromDepartment("Кардиология")) }
            Departments.RESUSCITATION -> { getArrayListPatients(patientDAO.getPatientsFromDepartment("Реанимация")) }
            Departments.NEUROLOGY -> { getArrayListPatients(patientDAO.getPatientsFromDepartment("Неврология")) }
            else -> { getArrayListPatients(patientDAO.getAllPatients()) }
        }
    }

    fun deletePatient(patient: Patient) = launch {
        patientDAO.deletePatient(patient)
    }

    fun updatePatient(id: Int) {
        navigationApi.router.navigateTo(PatientFragment.getInstance(id))
    }

    private fun getArrayListPatients(list: List<Patient>) {
        val arraylist = arrayListOf<Patient>()
        arraylist.addAll(list)
        _patientListLiveData.postValue(arraylist)
    }
}