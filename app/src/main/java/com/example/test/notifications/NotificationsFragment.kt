package com.example.test.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.test.R
import org.koin.android.viewmodel.ext.android.viewModel

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

  private val notificationsViewModel: NotificationsViewModel by viewModel()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    notificationsViewModel.text.observe(viewLifecycleOwner) {

    }
  }
}
