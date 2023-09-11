package com.example.hospital.dependencyInjectionCore

import com.example.hospital.database.DatabaseKoinModule
import com.example.hospital.features.departmentFragment.koin.DepartmentFragmentModule
import com.example.hospital.features.mainFragment.koin.MainFragmentModule
import com.example.hospital.features.patientFragment.koin.PatientFragmentModule
import com.example.hospital.navigation.NavigationModule
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

/**
 * объединяем все модули проекта в один список, чтобы передать в HospitalApplication
 */
object KoinCoreModules {
    val modules = arrayListOf(
        DatabaseKoinModule.databaseModule,
        NavigationModule.navigationModule,
        MainFragmentModule.mainFragmentModule,
        DepartmentFragmentModule.departmentFragmentModule,
        PatientFragmentModule.patientFragmentModule
    )
}

inline fun <reified T> Scope.getByKey(key: Keys): T {
    return get(named(key.toString()))
}

fun setKey(key: Keys): StringQualifier {
    return StringQualifier(key.toString())
}
