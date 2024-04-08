package com.example.roomdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RoomDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}