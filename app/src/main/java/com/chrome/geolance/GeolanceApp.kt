package com.chrome.geolance

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber.DebugTree
import timber.log.Timber.Forest.plant


@HiltAndroidApp
class GeolanceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        plant(DebugTree())
    }
}