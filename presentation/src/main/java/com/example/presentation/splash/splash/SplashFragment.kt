package com.example.presentation.splash.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.coreui.base.BaseFragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSplashBinding
import com.example.presentation.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView() {
        lifecycleScope.launchWhenResumed {
            delay(1000)
            if (preferenceRepository.getIsFirstTime().first()) {
                openOnBoardingScreen()
            } else {
                openHomeScreen()
            }
        }
    }

    private fun openOnBoardingScreen() {
        findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
    }

    private fun openHomeScreen() {
        Intent(requireActivity(),MainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK).also{
                startActivity(it)
            }
    }
}