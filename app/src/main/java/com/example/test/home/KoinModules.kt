package com.example.test.home

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModules = module {
  viewModel { HomeViewModel() }
}