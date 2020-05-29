package com.example.test.home.domain

import org.threeten.bp.LocalDate


data class HomeRecipe(
  val id: String,
  val name: String,
  val publishingDate: LocalDate,
  val shortDescription: String,
  val imageUrl: String
)