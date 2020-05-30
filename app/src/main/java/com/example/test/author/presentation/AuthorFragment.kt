package com.example.test.author.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.extensions.CircleTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_author.*

class AuthorFragment : Fragment(R.layout.fragment_author) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Picasso.get().load("https://picsum.photos/400/200").placeholder(R.drawable.ic_image_black_24dp).into(authorHeaderIv)
    Picasso.get().load("https://api.adorable.io/avatars/285/abott@adorable.png").placeholder(R.drawable.ic_person_black_24dp).transform(CircleTransform).into(authorAvatarIv)
  }

}