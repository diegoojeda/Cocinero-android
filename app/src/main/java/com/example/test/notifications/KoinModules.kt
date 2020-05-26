package com.example.test.notifications

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val notificationsModules = module {
  viewModel { NotificationsViewModel() }
}