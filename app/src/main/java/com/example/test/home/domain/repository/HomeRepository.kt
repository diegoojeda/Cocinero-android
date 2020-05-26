package com.example.test.home.domain.repository

import com.example.test.home.domain.HomeRecipe

interface HomeRepository {
  suspend fun getFeed(): List<HomeRecipe>
}