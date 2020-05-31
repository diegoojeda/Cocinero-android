package com.example.test.author.domain

interface AuthorRepository {
  suspend fun getById(id: String): Author
}