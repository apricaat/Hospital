package com.example.hospital.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hospital.database.patientDataBase.Patient
import com.example.hospital.database.patientDataBase.PatientDAO

@Database(entities = [Patient::class], version = 1)
abstract class HospitalDatabase: RoomDatabase() {

    abstract fun patientDao(): PatientDAO

}