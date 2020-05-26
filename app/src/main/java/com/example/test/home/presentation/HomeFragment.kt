package com.example.test.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.test.R
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

  private val homeViewModel: HomeViewModel by viewModel()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    homeViewModel.homeFeed.observe(viewLifecycleOwner) {

    }
  }
}
