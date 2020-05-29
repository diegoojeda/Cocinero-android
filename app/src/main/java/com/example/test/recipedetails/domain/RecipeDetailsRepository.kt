package com.example.test.recipedetails.domain

interface RecipeDetailsRepository {
  suspend fun getRecipeDetails(id: String): FullRecipe
}