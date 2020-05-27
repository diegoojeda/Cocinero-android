package com.example.test.recipedetails.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test.R
import org.koin.android.viewmodel.ext.android.viewModel

class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {

  private val viewModel: RecipeDetailsViewModel by viewModel()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}