package com.example.ktorserver

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
import org.apache.commons.io.IOUtils
import java.nio.charset.Charset

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
  install(ContentNegotiation) {
    gson {
      setPrettyPrinting()
      disableHtmlEscaping()
    }
  }
  install(Routing) {
    get("/status") {
      call.respond(HttpStatusCode.OK)
    }
    get("/home") {
      call.respond(getFileAsString("/HomeResponse.json"))
    }
    get("/recipes/{id}") {
      call.respond(HttpStatusCode.OK, getFileAsString("/FullRecipeResponse.json"))
    }
  }
}

fun getFileAsString(path: String) = IOUtils.toString(
  FakeServer::class.java.getResourceAsStream(path),
  Charset.forName("UTF-8")
).replace("/\\n/g", "")

data class HomeRecipe(
  val id: String,
  val name: String,
  val shortDescription: String,
  val imageUrl: String
)