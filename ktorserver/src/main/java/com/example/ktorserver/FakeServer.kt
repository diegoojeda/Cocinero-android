package com.example.ktorserver

import com.thedeanda.lorem.LoremIpsum
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.netty.util.internal.logging.InternalLoggerFactory
import io.netty.util.internal.logging.JdkLoggerFactory
import java.util.*
import kotlin.random.Random

private val loremGenerator = LoremIpsum.getInstance()

internal fun main() {
  FakeServer.start()
}

object FakeServer {
  fun start() {
    InternalLoggerFactory.setDefaultFactory(JdkLoggerFactory.INSTANCE)
    embeddedServer(Netty, 8080, module = Application::module).start()
  }
}

private fun Application.module() {
  install(DefaultHeaders)
  install(ContentNegotiation) { gson() }
  install(Routing) {
    get("/status") {
      call.respond(HttpStatusCode.OK)
    }
    get("/home") {
      call.respond(List(10) {
        recipe
      })
    }
  }
}


val recipe
  get() = HomeRecipe(
    UUID.randomUUID().toString(),
    loremGenerator.getTitle(2, 5),
    loremGenerator.getWords(5, 20),
    "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}"
  )

data class HomeRecipe(
  val id: String,
  val name: String,
  val shortDescription: String,
  val imageUrl: String
)
