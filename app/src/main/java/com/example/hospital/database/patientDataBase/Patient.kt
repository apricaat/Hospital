package com.example.hospital.database.patientDataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hospital.utils.patient.TransportationStates

@Entity(tableName = "table_patients")
data class Patient(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "diagnosis") val diagnosis: String,
    @ColumnInfo(name = "transportable") val transportable: TransportationStates,
    @ColumnInfo(name = "receipt_date") val receiptDate: String,
    @ColumnInfo(name = "discharge_date") val dischargeDate: String,
    @ColumnInfo(name = "departments") val departments: String,
    @ColumnInfo(name = "date_birth") val dateBirth: String,
    @ColumnInfo(name = "ward") val ward: String
)