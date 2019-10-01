package com.example.android_sprint3_challenge

import android.app.Application
import com.facebook.stetho.Stetho

class BANApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}