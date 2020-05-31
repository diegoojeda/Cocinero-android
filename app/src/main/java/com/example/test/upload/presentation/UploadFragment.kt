package com.example.test.upload.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_upload.*

class UploadFragment : Fragment(R.layout.fragment_upload) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    uploadRecipeAddIngredients.setOnClickListener {
      Log.d("ASDF", "Upload ingredients")
    }
    uploadRecipeAddSteps.setOnClickListener {
      Log.d("ASDF", "Upload steps")
    }
  }
}