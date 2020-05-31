package com.example.test.home

import com.example.test.home.data.HomeGateway
import com.example.test.home.data.NetworkHomeRepository
import com.example.test.home.domain.HomeService
import com.example.test.home.domain.repository.HomeRepository
import com.example.test.home.presentation.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import retrofit2.Retrofit

val homeModule = module {

  single { get<Retrofit>().create(HomeGateway::class.java) }

  singleBy<HomeRepository, NetworkHomeRepository>()

  single { HomeService(get()) }

  viewModel { HomeViewModel(get()) }
}