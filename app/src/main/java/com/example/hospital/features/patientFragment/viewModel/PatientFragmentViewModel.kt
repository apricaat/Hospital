package com.example.hospital.features.patientFragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hospital.base.BaseViewModel
import com.example.hospital.database.patientDataBase.Patient
import com.example.hospital.database.patientDataBase.PatientDAO
import kotlinx.coroutines.launch

class PatientFragmentViewModel(
    private val patientDAO: PatientDAO
): BaseViewModel() {

    private val _liveDataPatient: MutableLiveData<Patient> = MutableLiveData()
    val listDataPatient: LiveData<Patient> = _liveDataPatient

    private val _patientAddSuccess: MutableLiveData<Unit> = MutableLiveData()
    val patientAddSuccess: LiveData<Unit> = _patientAddSuccess

    fun loadPatient(id: Int) = launch {
        _liveDataPatient.postValue(patientDAO.getPatientById(id))
    }

    fun addPatient(patient: Patient) = launch {
        patientDAO.addPatient(patient)
        _patientAddSuccess.postValue(Unit)
    }

    fun updatePatient(patient: Patient) {
        patientDAO.addPatient(patient)
    }
}