package com.example.test.home.domain

import java.time.LocalDate

data class HomeRecipe(
  val id: String,
  val name: String,
  val publishingDate: LocalDate,
  val shortDescription: String,
  val imageUrl: String
)