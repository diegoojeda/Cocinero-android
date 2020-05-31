package com.example.test.recipedetails.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.example.test.R
import com.example.test.extensions.CircleTransform
import com.example.test.recipedetails.presentation.adapter.IngredientsAdapter
import com.example.test.views.CustomLoadingDialog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_recipe_details.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {

  private val loadingDialog: CustomLoadingDialog? by lazy {
    context?.let {
      CustomLoadingDialog(it)
    }
  }

  private val args: RecipeDetailsFragmentArgs by navArgs()
  private val viewModel: RecipeDetailsViewModel by viewModel { parametersOf(args.recipeId) }

  private val ingredientsAdapter = IngredientsAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    loadingDialog?.show()
    (activity as? AppCompatActivity)?.actionBar?.setDisplayHomeAsUpEnabled(true)
    recipeDetailsRv.adapter = ingredientsAdapter
    viewModel.fullRecipe.observe(viewLifecycleOwner) {
      loadingDialog?.hide()

      (activity as? AppCompatActivity)?.actionBar?.title = it.name

      Picasso.get().load(it.author.profilePic).transform(CircleTransform).into(recipeDetailsAuthorIv)
      recipeDetailsAuthorName.text = it.author.name

      recipeDetailsNameTv.text = it.name
      recipeDetailsDescriptionTv.text = it.shortDescription
      Picasso.get().load(it.imageUrl).into(recipeDetailsIv)
      ingredientsAdapter.items = it.ingredients
    }
  }
}