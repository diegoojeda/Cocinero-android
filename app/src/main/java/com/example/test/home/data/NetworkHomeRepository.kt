package com.example.test.home.data

import com.example.test.home.domain.HomeRecipe
import com.example.test.home.domain.repository.HomeRepository

class NetworkHomeRepository(private val gateway: HomeGateway) : HomeRepository {
  override suspend fun getFeed(): List<HomeRecipe> = gateway.getHome()
}