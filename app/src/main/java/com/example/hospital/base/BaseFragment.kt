package com.example.hospital.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var internalBinding: ViewBinding? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = requireNotNull(internalBinding) as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        internalBinding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(internalBinding).root
    }

    override fun onDestroyView() {
        internalBinding = null
        super.onDestroyView()
    }

}