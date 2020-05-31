package com.example.test.recipedetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.test.recipedetails.domain.RecipeDetailsService

class RecipeDetailsViewModel(
  private val recipeId: String,
  private val recipeDetailsService: RecipeDetailsService
) : ViewModel() {

  val fullRecipe = liveData {
    runCatching {
      emit(recipeDetailsService.getRecipeDetails(recipeId))
    }.onFailure {
      it.printStackTrace()
    }
  }
}