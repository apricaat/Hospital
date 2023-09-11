package com.example.hospital.entity

import com.example.hospital.utils.patient.TransportationStates

data class Patient(
    var name: String,
    var surname: String,
    var patronymic: String,
    var dateOfBirth: String,
    var diagnosis: String,
    var transportable: TransportationStates,
    var receiptDate: String,
    var dischargeDate: String
)