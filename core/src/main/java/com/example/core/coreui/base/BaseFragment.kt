package com.example.core.coreui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.core.coredomain.repository.PreferenceRepository
import javax.inject.Inject

abstract class BaseFragment<VB:ViewBinding>(private val inflate : (LayoutInflater, ViewGroup?, Boolean) -> VB) : Fragment(){

    private var _binding:VB?=null
    val binding get() = _binding!!

    @Inject
    lateinit var preferenceRepository: PreferenceRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=inflate.invoke(inflater,container,false)
        onCreateView()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    abstract fun onCreateView()
}