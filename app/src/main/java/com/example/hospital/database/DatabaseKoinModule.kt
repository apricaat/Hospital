package com.example.hospital.database

import androidx.room.Room
import com.example.hospital.database.patientDataBase.Patient
import com.example.hospital.database.patientDataBase.PatientDAO
import com.example.hospital.dependencyInjectionCore.Keys
import com.example.hospital.dependencyInjectionCore.getByKey
import org.koin.dsl.module

object DatabaseKoinModule {

    val databaseModule = module {
        single {
            Room.databaseBuilder(
                getByKey(Keys.APPLICATION_CONTEXT),
                HospitalDatabase::class.java,
                "table_patients"
            ).build().patientDao()
        }
    }
}


