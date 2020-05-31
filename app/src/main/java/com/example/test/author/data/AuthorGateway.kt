package com.example.test.author.data

import com.example.test.author.domain.Author
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthorGateway {
  @GET("/author/{id}")
  suspend fun getAuthorById(@Path("id") id: String): Author
}