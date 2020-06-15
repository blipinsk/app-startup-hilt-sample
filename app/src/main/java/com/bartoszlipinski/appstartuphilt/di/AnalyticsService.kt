package com.bartoszlipinski.appstartuphilt.di

import javax.inject.Inject
import javax.inject.Singleton

//for the simplicity of the example, this is just a plain old class (no need for interface+impl)
@Singleton
class AnalyticsService @Inject constructor() {

    private var internalIsInitialized = false

    val isInitialized: Boolean
        get() {
            return internalIsInitialized
        }

    //dummy initialization implementation
    fun initialize() {
        internalIsInitialized = true
    }
}