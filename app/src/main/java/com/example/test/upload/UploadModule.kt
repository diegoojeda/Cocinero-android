package com.example.test.upload

import com.example.test.upload.data.NetworkUploadRepository
import com.example.test.upload.data.UploadGateway
import com.example.test.upload.domain.UploadRepository
import com.example.test.upload.domain.UploadService
import com.example.test.upload.presentation.UploadViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import retrofit2.Retrofit

val uploadModule = module {

  single { get<Retrofit>().create(UploadGateway::class.java) }
  singleBy<UploadRepository, NetworkUploadRepository>()
  single { UploadService(get()) }

  viewModel { UploadViewModel(get()) }
}