package com.example.test.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

  private val homeViewModel: HomeViewModel by viewModel()

  private val adapter = HomeAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    fragmentHomeRv.adapter = adapter
    homeViewModel.homeFeed.observe(viewLifecycleOwner) {
      adapter.items = it
    }
  }
}
