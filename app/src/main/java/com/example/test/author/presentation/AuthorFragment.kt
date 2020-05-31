package com.example.test.author.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.test.R
import com.example.test.author.presentation.adapter.AuthorRecipesAdapter
import com.example.test.extensions.CircleTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_author.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AuthorFragment : Fragment(R.layout.fragment_author) {

  private val authorViewModel: AuthorViewModel by viewModel { parametersOf("1234") }

  private val recipesAdapter = AuthorRecipesAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    authorRecipesRv.adapter = recipesAdapter
    authorViewModel.author.observe(viewLifecycleOwner) {
      recipesAdapter.items = it.recipes
      authorNameTv.text = it.name
      authorBioTv.text = it.bio
      Picasso.get().load(it.headerPic).placeholder(R.drawable.ic_image_black_24dp).into(authorHeaderIv)
      Picasso.get().load(it.profilePic).placeholder(R.drawable.ic_person_black_24dp).transform(CircleTransform).into(authorAvatarIv)

      Log.d("asdf", it.toString())
    }
  }

}