package com.example.test.recipedetails.presentation

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.test.R
import com.example.test.extensions.CircleTransform
import com.example.test.recipedetails.domain.FullRecipe
import com.example.test.recipedetails.domain.RecipeStep
import com.example.test.recipedetails.presentation.adapter.IngredientsAdapter
import com.example.test.recipesteps.presentation.RecipeStepsFragment
import com.example.test.views.CustomLoadingDialog
import com.squareup.picasso.Picasso
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_recipe_details.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {

  private val loadingDialog: CustomLoadingDialog? by lazy { context?.let { CustomLoadingDialog(it) } }
  private val args: RecipeDetailsFragmentArgs by navArgs()
  private val viewModel: RecipeDetailsViewModel by viewModel { parametersOf(args.recipeId) }

  private val ingredientsAdapter = IngredientsAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    loadingDialog?.show()
    (activity as? AppCompatActivity)?.actionBar?.setDisplayHomeAsUpEnabled(true)
    recipeDetailsRv.adapter = ingredientsAdapter
    viewModel.fullRecipe.observe(viewLifecycleOwner) { recipe ->
      loadingDialog?.hide()
      renderRecipe(recipe)
    }
  }

  private fun renderRecipe(recipe: FullRecipe) {
    (activity as? AppCompatActivity)?.actionBar?.title = recipe.name

    Picasso.get().load(recipe.author.profilePic).transform(CircleTransform).into(recipeDetailsAuthorIv)
    Picasso.get().load(recipe.imageUrl).into(recipeDetailsIv)

    recipeDetailsAuthorName.text = recipe.author.name
    recipeDetailsNameTv.text = recipe.name
    recipeDetailsDescriptionTv.text = recipe.shortDescription
    ingredientsAdapter.items = recipe.ingredients
    recipeDetailsStartCooking.setOnClickListener {
      findNavController().navigate(RecipeDetailsFragmentDirections.navigationHomeOpenRecipeSteps(RecipeSteps(recipe.steps)))
    }
  }
}

//Just for navigation purposes
@Parcelize
data class RecipeSteps(
  val steps: List<RecipeStep>
) : Parcelable