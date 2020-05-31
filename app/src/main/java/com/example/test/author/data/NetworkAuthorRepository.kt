package com.example.test.author.data

import com.example.test.author.domain.Author
import com.example.test.author.domain.AuthorRepository

class NetworkAuthorRepository(private val authorGateway: AuthorGateway): AuthorRepository {
  override suspend fun getById(id: String): Author = authorGateway.getAuthorById(id)
}