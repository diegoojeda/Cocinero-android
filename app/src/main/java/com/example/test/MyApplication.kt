package com.example.test

import android.app.Application
import com.example.test.home.homeModules
import com.example.test.notifications.notificationsModules
import com.example.test.search.searchModules
import org.koin.core.context.startKoin

class MyApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      printLogger()
      modules(koinModules)
    }
  }
}

val koinModules = listOf(
  homeModules,
  searchModules,
  notificationsModules
)