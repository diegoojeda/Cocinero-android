package com.example.test.recipedetails.domain

import com.example.test.author.domain.AuthorShort
import org.threeten.bp.LocalDate

data class FullRecipe(
  val id: String,
  val name: String,
  val publishingDate: LocalDate,
  val shortDescription: String,
  val imageUrl: String,
  val difficulty: Int,
  val lengthMinutes: Int,
  val author: AuthorShort,
  val steps: List<String>,
  val ingredients: List<String>
)