package com.example.test.upload.data

import com.example.test.upload.domain.UploadRepository

class NetworkUploadRepository(private val uploadGateway: UploadGateway): UploadRepository {
  override suspend fun upload() {
    TODO("Not yet implemented")
  }
}