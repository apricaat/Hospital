package com.example.hospital.features.patientFragment.ui

import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.hospital.R
import com.example.hospital.base.BaseFragment
import com.example.hospital.database.patientDataBase.Patient
import com.example.hospital.databinding.PatientFragmentBinding
import com.example.hospital.features.patientFragment.viewModel.PatientFragmentViewModel
import com.example.hospital.utils.patient.TransportationStates
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.android.ext.android.inject

class PatientFragment : BaseFragment<PatientFragmentBinding>(
    PatientFragmentBinding::inflate
) {

    private val viewModel: PatientFragmentViewModel by inject()

    private val itemsDepartment =
        listOf("Хирургия", "Терапия", "Неврология", "Реанимация", "Кардиология")
    private val itemsWard =
        listOf("Палата №1", "Палата №2", "Палата №3", "Палата №4", "Палата №5", "Палата №6")
    private val itemsTransportable = listOf("Лежачий", "Ходячий", "Нетранспортабельный")

    override fun onResume() {
        super.onResume()

        viewModel.listDataPatient.observe(viewLifecycleOwner) {
            setupPatient(it)
        }
        viewModel.patientAddSuccess.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Пациент успешно сохранён", Toast.LENGTH_LONG).show()
        }

        arguments?.get("KEYS")?.let {
            viewModel.loadPatient(it as Int)
        }

        if (arguments?.get("KEYS") == null) {
            binding.btnSavePatient.setOnClickListener { addPatient(false) }
        } else {
            binding.btnSavePatient.setOnClickListener { addPatient(true) }
        }

        val adapterDepartments =
            ArrayAdapter(requireContext(), R.layout.list_departments_item, itemsDepartment)
        val adapterWard = ArrayAdapter(requireContext(), R.layout.list_departments_item, itemsWard)
        val adapterTransportable =
            ArrayAdapter(requireContext(), R.layout.list_departments_item, itemsTransportable)
        binding.autoCompleteDepartment.setAdapter(adapterDepartments)
        binding.autoCompleteWard.setAdapter(adapterWard)
        binding.autoCompleteTransportable.setAdapter(adapterTransportable)
    }

    private fun setupPatient(patient: Patient) {
        binding.run {
            editTextFullNamePatient.editText?.setText(patient.fullName)
            editTextDiagnosisPatient.editText?.setText(patient.diagnosis)
            editTextDateBirth.editText?.setText("")
            editTextDepartment.editText?.setText(patient.departments)
            editTextWard.editText?.setText(patient.ward)
        }
    }

    private fun addPatient(update: Boolean) {
        var patient: Patient? = null

        binding.run {
            val name = editTextFullNamePatient.editText?.text?.toString() ?: ""
            val diagnosis = editTextDiagnosisPatient.editText?.text?.toString() ?: ""
            val dateBirth = editTextDateBirth.editText?.text?.toString() ?: ""
            val department = editTextDepartment.editText?.text?.toString() ?: ""
            val ward = editTextWard.editText?.text?.toString() ?: ""
            val dischargeDate = editTextDischarge.editText?.text?.toString() ?: ""
            val transportable =
                when (editTextTransportable.editText?.text?.toString()) {
                    "Лежачий" -> TransportationStates.RECUMBENT
                    "Ходячий" -> TransportationStates.WALKING
                    "Нетранспортабельный" -> TransportationStates.NONTRANSPORTABLE
                    else -> TransportationStates.WALKING
                }

            patient = Patient(
                fullName = name,
                diagnosis = diagnosis,
                dischargeDate = dischargeDate,
                transportable = transportable,
                ward = ward,
                departments = department,
                receiptDate = "",
                dateBirth = dateBirth
            )
        }

        if (update) {
            patient?.let { viewModel.updatePatient(it) }
        } else {
            patient?.let { viewModel.addPatient(patient!!) }
        }
    }

    companion object {

        fun getInstance(id: Int? = null) = FragmentScreen {

            PatientFragment().apply {
                arguments = bundleOf("KEYS" to id)
            }
        }
    }
}