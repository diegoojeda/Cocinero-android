package com.example.test.home.data

import com.example.test.home.domain.HomeRecipe
import retrofit2.http.GET

interface HomeGateway {

  @GET("/home")
  suspend fun getHome(): List<HomeRecipe>

}