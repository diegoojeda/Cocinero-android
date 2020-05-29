package com.example.test.recipedetails.data

import com.example.test.recipedetails.domain.FullRecipe
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeDetailsGateway {
  @GET("/recipes/{id}")
  suspend fun getFullRecipe(@Path("id") recipeId: String): FullRecipe
}