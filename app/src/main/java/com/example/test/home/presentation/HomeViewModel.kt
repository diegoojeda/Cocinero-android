package com.example.test.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.extensions.launch
import com.example.test.home.domain.HomeRecipe
import com.example.test.home.domain.HomeService

class HomeViewModel(private val homeService: HomeService) : ViewModel() {

  private val _homeFeed: MutableLiveData<List<HomeRecipe>> = MutableLiveData()
  val homeFeed: LiveData<List<HomeRecipe>> = _homeFeed

  init {
    launch {
      _homeFeed.value = homeService.getHome()
    }
  }

  fun addToFav(id: String) {

  }

}