package com.example.test.author

import com.example.test.author.data.AuthorGateway
import com.example.test.author.data.NetworkAuthorRepository
import com.example.test.author.domain.AuthorRepository
import com.example.test.author.domain.AuthorService
import com.example.test.author.presentation.AuthorViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import retrofit2.Retrofit

val authorModule = module {
  single { get<Retrofit>().create(AuthorGateway::class.java) }

  singleBy<AuthorRepository, NetworkAuthorRepository>()

  single { AuthorService(get()) }

  viewModel { (authorId: String) ->
    AuthorViewModel(authorId, get())
  }
}