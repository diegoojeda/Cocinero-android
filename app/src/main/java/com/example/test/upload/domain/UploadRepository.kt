package com.example.test.upload.domain

interface UploadRepository {
  suspend fun upload()
}