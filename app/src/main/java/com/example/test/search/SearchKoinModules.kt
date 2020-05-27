package com.example.test.search

import com.example.test.search.presentation.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModules = module {
  viewModel { SearchViewModel() }
}