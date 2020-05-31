package com.example.test.recipesteps.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.recipedetails.domain.RecipeStep
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_recipe_single_step.*

class RecipeStepFragment(private val recipeStep: RecipeStep) : Fragment(R.layout.fragment_recipe_single_step) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Picasso.get().load(recipeStep.image).into(recipeSingleStepImage)
    recipeSingleStepText.text = recipeStep.text
  }

}