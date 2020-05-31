package com.example.test.recipedetails.domain

import android.os.Parcelable
import com.example.test.author.domain.AuthorShort
import com.example.test.ingredient.domain.SimpleIngredient
import kotlinx.android.parcel.Parcelize
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
  val steps: List<RecipeStep>,
  val ingredients: List<IngredientWithAmount>
)

@Parcelize
data class RecipeStep(
  val image: String,
  val text: String
) : Parcelable

data class IngredientWithAmount(
  val ingredient: SimpleIngredient,
  val amount: Int,
  val unit: String
)