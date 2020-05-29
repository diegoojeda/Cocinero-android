package com.example.test.recipedetails.domain

class RecipeDetailsService(private val recipeDetailsRepository: RecipeDetailsRepository) {
  suspend fun getRecipeDetails(id: String) = recipeDetailsRepository.getRecipeDetails(id)
}