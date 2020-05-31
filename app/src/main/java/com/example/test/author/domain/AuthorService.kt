package com.example.test.author.domain

class AuthorService(private val authorRepository: AuthorRepository) {
  suspend fun getAuthor(id: String) = authorRepository.getById(id)
}