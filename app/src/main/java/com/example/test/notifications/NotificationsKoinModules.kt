package com.example.test.notifications

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val notificationsModule = module {
  viewModel { NotificationsViewModel() }
}