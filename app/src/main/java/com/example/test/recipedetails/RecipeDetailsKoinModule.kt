package com.example.test.recipedetails

import com.example.test.recipedetails.data.NetworkRecipeDetailsRepository
import com.example.test.recipedetails.data.RecipeDetailsGateway
import com.example.test.recipedetails.domain.RecipeDetailsRepository
import com.example.test.recipedetails.domain.RecipeDetailsService
import com.example.test.recipedetails.presentation.RecipeDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import retrofit2.Retrofit

val recipeDetailsModule = module {

  single { get<Retrofit>().create(RecipeDetailsGateway::class.java) }
  singleBy<RecipeDetailsRepository, NetworkRecipeDetailsRepository>()
  single { RecipeDetailsService(get()) }

  viewModel { (recipeId: String) ->
    RecipeDetailsViewModel(recipeId, get())
  }

}