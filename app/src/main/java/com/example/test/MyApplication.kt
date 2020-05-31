package com.example.test

import android.app.Application
import com.example.ktorserver.FakeServer
import com.example.test.author.authorModule
import com.example.test.home.homeModule
import com.example.test.notifications.notificationsModule
import com.example.test.recipedetails.recipeDetailsModule
import com.example.test.search.searchModule
import com.example.test.upload.uploadModule
import com.google.gson.*
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.jakewharton.threetenabp.AndroidThreeTen
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MyApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      printLogger()
      modules(koinModules)
    }
    FakeServer.start()
    AndroidThreeTen.init(this)
  }
}

val okHttpModule = module {

  single(named<HttpLoggingInterceptor>()) {
    HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
  }

  single {
    OkHttpClient.Builder().apply {
      connectTimeout(30, TimeUnit.SECONDS)
      readTimeout(30, TimeUnit.SECONDS)
      writeTimeout(30, TimeUnit.SECONDS)
      addInterceptor(get<HttpLoggingInterceptor>(named<HttpLoggingInterceptor>()))
    }.build()
  }
}

val retrofitModule = module {

  single {
    GsonBuilder()
      .setDateFormat("yyyy-mm-dd")
      .registerTypeAdapter(LocalDate::class.java, LocalDateTypeAdapter())
      .create()
  }

  single {
    Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .client(get())
      .addConverterFactory(GsonConverterFactory.create(get()))
      .build()
  }
}

val koinModules = listOf(
  retrofitModule,
  okHttpModule,
  homeModule,
  searchModule,
  notificationsModule,
  recipeDetailsModule,
  authorModule,
  uploadModule
)

class LocalDateTypeAdapter : TypeAdapter<LocalDate>() {

  override fun write(out: JsonWriter, value: LocalDate) {
    out.value(DateTimeFormatter.ISO_LOCAL_DATE.format(value))
  }

  override fun read(input: JsonReader): LocalDate = LocalDate.parse(input.nextString())
}