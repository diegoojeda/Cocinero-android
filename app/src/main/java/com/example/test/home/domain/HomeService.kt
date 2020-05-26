package com.example.test.home.domain

import com.example.test.home.domain.repository.HomeRepository

class HomeService(private val homeRepository: HomeRepository) {
  suspend fun getHome() = homeRepository.getFeed()
}