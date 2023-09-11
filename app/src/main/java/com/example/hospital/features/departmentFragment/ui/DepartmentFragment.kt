package com.example.hospital.features.departmentFragment.ui

import androidx.core.os.bundleOf
import com.example.hospital.base.BaseFragment
import com.example.hospital.database.patientDataBase.Patient
import com.example.hospital.databinding.DepartmentFragmentBinding
import com.example.hospital.features.departmentFragment.viewModel.DepartmentFragmentViewModel
import com.example.hospital.utils.department.Departments
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.android.ext.android.inject

class DepartmentFragment : BaseFragment<DepartmentFragmentBinding>(
    DepartmentFragmentBinding::inflate
) {

    private val viewModel: DepartmentFragmentViewModel by inject()
    private val patientAdapter = PatientsRecyclerView(
        callbackUpdatePatient = { updatePatient(it.id) },
        callbackDeletePatient = { patient -> deletePatient(patient) })

    override fun onResume() {
        super.onResume()
        if (arguments?.get("DepartmentKey") == null) {
            viewModel.onInit()
        } else {
            viewModel.onInit(arguments?.get("DepartmentKey") as Departments)
        }

        viewModel.patientListLiveData.observe(viewLifecycleOwner) { listPatients ->
            patientAdapter.addItems(listPatients)
            binding.departmentRecyclerView.adapter = patientAdapter
        }
    }

    private fun deletePatient(patient: Patient) {
        viewModel.deletePatient(patient)
    }

    private fun updatePatient(id: Int) {
        viewModel.updatePatient(id)
    }

    companion object {

        fun getInstance(department: Departments? = null) = FragmentScreen {
            DepartmentFragment().apply {
                arguments = bundleOf("DepartmentKey" to department)
            }
        }
    }
}