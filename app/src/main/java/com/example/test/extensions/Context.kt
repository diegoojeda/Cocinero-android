package com.example.test.extensions

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.annotation.StyleableRes

inline fun Context.getStyledAttributes(attrs: AttributeSet?, @StyleableRes style: IntArray, block: TypedArray.() -> Unit) =
  attrs?.let {
    val typedArray = obtainStyledAttributes(attrs, style)
    try {
      typedArray.block()
    } finally {
      typedArray.recycle()
    }
  }