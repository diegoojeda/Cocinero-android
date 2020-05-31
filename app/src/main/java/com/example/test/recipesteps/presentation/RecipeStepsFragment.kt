package com.example.test.recipesteps.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_recipe_steps.*


class RecipeStepsFragment : DialogFragment() {

  private val arguments: RecipeStepsFragmentArgs by navArgs()

  private val adapter by lazy {
    RecipeStepsAdapter(childFragmentManager, lifecycle).apply {
      items = arguments.recipeSteps.steps
    }
  }

  override fun onResume() {
    super.onResume()
    val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
    params.width = WindowManager.LayoutParams.MATCH_PARENT
    params.height = WindowManager.LayoutParams.MATCH_PARENT
    dialog?.window?.attributes = params as WindowManager.LayoutParams
  }


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
    inflater.inflate(R.layout.fragment_recipe_steps, container, false)


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recipeStepsViewPager.adapter = adapter
  }
}