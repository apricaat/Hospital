package com.example.hospital.database.patientDataBase

import androidx.room.*
import java.net.IDN

@Dao
interface PatientDAO {

    @Query("SELECT * FROM table_patients WHERE diagnosis IN (:diagnosis)")
    fun findByDiagnosis(diagnosis: String): List<Patient>

    @Query("SELECT * FROM table_patients WHERE diagnosis IN (:diagnosis) OR full_name IN (:diagnosis)")
    fun findPatient(diagnosis: String): List<Patient>

    @Query("SELECT * FROM table_patients WHERE departments IN (:department)")
    fun getPatientsFromDepartment(department: String): List<Patient>

    @Query("SELECT COUNT(*) FROM table_patients")
    fun getPatientsCount(): Int

    @Query("SELECT COUNT(*) FROM table_patients WHERE departments IN (:department)")
    fun getPatientCountFromDepartment(department: String): Int

    @Query("SELECT * FROM table_patients WHERE id IN(:id)")
    fun getPatientById(id: Int): Patient

    @Query("SELECT * FROM table_patients")
    fun getAllPatients(): List<Patient>

    @Delete
    fun deletePatient(patient: Patient)

    @Insert
    fun addPatient(patient: Patient)
}
