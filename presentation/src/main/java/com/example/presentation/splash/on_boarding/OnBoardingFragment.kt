package com.example.presentation.splash.on_boarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.coreui.base.BaseFragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentOnBoardingBinding
import com.example.presentation.main.MainActivity


class OnBoardingFragment : BaseFragment<FragmentOnBoardingBinding>(FragmentOnBoardingBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView() {
        binding.tvNext.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                preferenceRepository.setIsFirstTime(value = true)
            }
            openHomeScreen()
        }
    }
    private fun openHomeScreen(){
         Intent(requireActivity(),MainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK).also{
                startActivity(it)
            }
    }
}