package com.example.test.recipedetails.data

import com.example.test.recipedetails.domain.FullRecipe
import com.example.test.recipedetails.domain.RecipeDetailsRepository

class NetworkRecipeDetailsRepository(private val gateway: RecipeDetailsGateway) : RecipeDetailsRepository {
  override suspend fun getRecipeDetails(id: String): FullRecipe = gateway.getFullRecipe(id)
}