package com.example.test.author.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.author.domain.AuthorShortRecipe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recipe_simple_row.view.*
import kotlin.properties.Delegates

class AuthorRecipesAdapter : RecyclerView.Adapter<AuthorRecipesAdapter.AuthorRecipeViewHolder>() {

  var items: List<AuthorShortRecipe> by Delegates.observable(emptyList()) { _, _, _ ->
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorRecipeViewHolder =
    AuthorRecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recipe_simple_row, parent, false))

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: AuthorRecipeViewHolder, position: Int) = holder.bind(items[position])

  inner class AuthorRecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(recipe: AuthorShortRecipe) {
      Picasso.get().load(recipe.imageUrl).into(itemView.recipeSimpleImage)
      itemView.recipeSimpleName.text = recipe.name
    }
  }
}