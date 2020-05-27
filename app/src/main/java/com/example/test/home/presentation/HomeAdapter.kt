package com.example.test.home.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.home.domain.HomeRecipe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_recipe_row.view.*
import kotlin.properties.Delegates

class HomeAdapter(
//  private val addClicked: (recipeId: String) -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

  var items: List<HomeRecipe> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
    HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_recipe_row, parent, false))

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
    holder.bind(items[position])

  inner class HomeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(homeRecipe: HomeRecipe) {
      Picasso.get().load(homeRecipe.imageUrl).placeholder(R.drawable.ic_image_black_24dp).into(view.homeRecipeImage)
      view.homeRecipeName.text = homeRecipe.name
      view.homeRecipeDescription.text = homeRecipe.shortDescription
      view.homeRecipeCta.setOnClickListener {
//        addClicked(homeRecipe.id)
      }
    }
  }
}