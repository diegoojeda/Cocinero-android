package com.example.test.search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class SearchViewModel(val searchService: SearchService) : ViewModel() {

  val searchData = liveData<List<>> {  }

}