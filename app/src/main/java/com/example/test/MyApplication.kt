package com.example.test

import android.app.Application
import com.example.ktorserver.FakeServer
import com.example.test.home.homeModules
import com.example.test.notifications.notificationsModules
import com.example.test.search.searchModules
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get
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
    Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .client(get())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }
}

val koinModules = listOf(
  retrofitModule,
  okHttpModule,
  homeModules,
  searchModules,
  notificationsModules
)