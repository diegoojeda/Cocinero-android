package com.example.test.recipedetails.domain

import com.example.test.author.domain.Author
import java.time.LocalDate

data class FullRecipe(
  val id: String,
  val name: String,
  val publishingDate: LocalDate,
  val shortDescription: String,
  val imageUrl: String,
  val difficulty: Int,
  val lengthMinutes: Int,
  val author: Author

)