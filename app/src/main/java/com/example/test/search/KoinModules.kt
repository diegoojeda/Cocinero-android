package com.example.test.search

import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModules = module {
  viewModel { SearchViewModel() }
}