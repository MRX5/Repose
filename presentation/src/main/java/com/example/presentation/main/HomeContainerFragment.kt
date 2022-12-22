package com.example.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.core.coreui.base.BaseFragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentHomeContainerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeContainerFragment : BaseFragment<FragmentHomeContainerBinding>(FragmentHomeContainerBinding::inflate) {


    override fun onCreateView() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView(){
        val navController = Navigation.findNavController(requireActivity(),R.id.home_container)
        NavigationUI.setupWithNavController(binding.bottomNav,navController)
        binding.bottomNav.setupWithNavController(navController)
    }


}