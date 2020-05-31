package com.example.test.recipesteps.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.lifecycle.Lifecycle
import com.example.test.recipedetails.domain.RecipeStep
import kotlin.properties.Delegates

class RecipeStepsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

  var items: List<RecipeStep> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

  override fun getItemCount(): Int = items.size

  override fun createFragment(position: Int): Fragment =
    RecipeStepFragment(items[position])
}