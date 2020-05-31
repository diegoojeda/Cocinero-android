package com.example.test.author.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.test.author.domain.Author
import com.example.test.author.domain.AuthorService

class AuthorViewModel(
  private val authorId: String,
  private val authorService: AuthorService
): ViewModel() {

  val author: LiveData<Author> = liveData { emit(authorService.getAuthor(authorId)) }

}