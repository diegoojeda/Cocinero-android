package com.example.test.author.domain

data class AuthorShort(
  val id: String,
  val name: String,
  val profilePic: String
)

data class Author (
  val id: String,
  val name: String,
  val profilePic: String,
  val bio: String,
  val headerPic: String
)