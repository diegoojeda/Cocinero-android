package com.example.test.views

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.test.R

class CustomLoadingDialog(context: Context) : Dialog(context, R.style.FloatingDialog) {

  init {
    setTitle(null)
    setCancelable(false)

    val attributes = window?.attributes
    if (attributes != null) {
      attributes.gravity = Gravity.CENTER_HORIZONTAL
    }
    window?.attributes = attributes
//    window?.setBackgroundDrawableResource("#00FFFFF")º

    val view = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null)

    val spinnerView = view.findViewById<ImageView>(R.id.loadingDialogIcon)
    val size = context.resources.getDimensionPixelSize(R.dimen.spinner_size)
    val params = LinearLayout.LayoutParams(size, size)

    addContentView(view, params)
  }

}