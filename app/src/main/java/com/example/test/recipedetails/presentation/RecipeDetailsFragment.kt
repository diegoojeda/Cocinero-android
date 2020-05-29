package com.example.test.recipedetails.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.example.test.R
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {

  private val args: RecipeDetailsFragmentArgs by navArgs()
  private val viewModel: RecipeDetailsViewModel by viewModel { parametersOf(args.recipeId) }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.fullRecipe.observe(viewLifecycleOwner) {
      Log.d("ASDF", it.toString())
    }
  }
}