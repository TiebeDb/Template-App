package com.example.templateapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Entry point for Hilt to start dependency injection.
@HiltAndroidApp
class TemplateApplication : Application()
