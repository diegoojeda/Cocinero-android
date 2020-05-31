package com.example.test.upload.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.test.R
import com.example.test.extensions.getStyledAttributes
import kotlinx.android.synthetic.main.add_to_recipe_row.view.*

class AddToRecipeRowView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

  var text: String
    get() = addToRecipeRowText.text.toString()
    set(value) {
      addToRecipeRowText.text = value
    }

  init {
    inflate(context, R.layout.add_to_recipe_row, this)
    context.getStyledAttributes(attrs, R.styleable.AddToRecipeRowView) {
      getString(R.styleable.AddToRecipeRowView_title)?.let {
        text = it
      }
    }
  }

}