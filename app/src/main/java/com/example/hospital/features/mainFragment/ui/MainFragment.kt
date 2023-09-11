package com.example.hospital.features.mainFragment.ui

import com.example.hospital.base.BaseFragment
import com.example.hospital.databinding.MainFragmentBinding
import com.example.hospital.features.mainFragment.viewModel.MainFragmentViewModel
import com.example.hospital.utils.department.Departments
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<MainFragmentBinding>(
    MainFragmentBinding::inflate
) {

    private val viewModel: MainFragmentViewModel by viewModel()

    override fun onResume() {
        super.onResume()
        binding.apply {
            btnCardiology.setOnClickListener { viewModel.routeTo(Departments.CARDIOLOGY) }
            btnNeurology.setOnClickListener { viewModel.routeTo(Departments.NEUROLOGY) }
            btnResuscitation.setOnClickListener { viewModel.routeTo(Departments.RESUSCITATION) }
            btnSurgery.setOnClickListener { viewModel.routeTo(Departments.SURGERY) }
            btnTherapy.setOnClickListener { viewModel.routeTo(Departments.THERAPY) }
            btnAddPatient.setOnClickListener { viewModel.routeToAddNewPatient() }
            btnAllPatients.setOnClickListener { viewModel.routeTo() }
        }
    }

    companion object {
        var screenMain = FragmentScreen {
            MainFragment()
        }
    }
}