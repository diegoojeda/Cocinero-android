package com.example.test.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.test.home.domain.HomeRecipe
import com.example.test.home.domain.HomeService

class HomeViewModel(private val homeService: HomeService) : ViewModel() {

  val homeFeed: LiveData<List<HomeRecipe>> = liveData { emit(homeService.getHome()) }

  fun addToFav(id: String) {

  }

}