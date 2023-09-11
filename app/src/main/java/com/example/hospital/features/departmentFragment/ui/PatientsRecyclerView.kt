package com.example.hospital.features.departmentFragment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.R
import com.example.hospital.database.patientDataBase.Patient

class PatientsRecyclerView(
    private val callbackUpdatePatient: (patient: Patient) -> Unit,
    private val callbackDeletePatient: (patient: Patient) -> Unit,
) : RecyclerView.Adapter<PatientsRecyclerView.ViewHolderPatient>() {

    private var patientList: List<Patient> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPatient {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.patient_card_view, parent, false)
        return ViewHolderPatient(view, callbackUpdatePatient, callbackDeletePatient)
    }

    override fun onBindViewHolder(holder: ViewHolderPatient, position: Int) {
        holder.setItems(patientList[position])
    }

    override fun getItemCount(): Int = patientList.size

    fun addItems(listPatients: List<Patient>) {
        this.patientList = listPatients
    }

    class ViewHolderPatient(
        private val itemView: View,
        private val callbackUpdatePatient: (patient: Patient) -> Unit,
        private val callbackDeletePatient: (patient: Patient) -> Unit,
    ) : RecyclerView.ViewHolder(itemView) {

        fun setItems(patient: Patient) {
            itemView.findViewById<TextView>(R.id.patientFullName).text = patient.fullName
            itemView.findViewById<TextView>(R.id.patientDepartment).text = patient.departments
            itemView.findViewById<TextView>(R.id.patientWard).text = patient.ward
            itemView.findViewById<TextView>(R.id.patientDiagnosis).text = patient.diagnosis
            itemView.findViewById<Button>(R.id.btnUpdateDataPatient).setOnClickListener { callbackUpdatePatient.invoke(patient) }
            itemView.findViewById<Button>(R.id.btnDeletePatient).setOnClickListener { callbackDeletePatient.invoke(patient) }
        }

    }
}