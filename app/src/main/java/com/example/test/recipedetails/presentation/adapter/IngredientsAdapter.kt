package com.example.test.recipedetails.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.recipedetails.domain.IngredientWithAmount
import kotlinx.android.synthetic.main.recipe_details_ingredient_row.view.*
import kotlin.properties.Delegates

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.IngredientViewHolder>() {

  var items: List<IngredientWithAmount> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
    IngredientViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recipe_details_ingredient_row, parent, false))

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) = holder.bind(items[position])

  inner class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: IngredientWithAmount) {
      itemView.ingredientRowName.text = item.ingredient.name
      itemView.ingredientRowAmount.text = "${item.amount} ${item.unit}"
    }
  }
}