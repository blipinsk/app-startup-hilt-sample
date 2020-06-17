package com.bartoszlipinski.appstartuphilt.di

import javax.inject.Inject
import javax.inject.Singleton

//for the simplicity of the example, this is just a plain old class (no need for interface+impl)
@Singleton
class BugReportingService @Inject constructor() {

    var isInitialized: Boolean = false
        private set

    //dummy initialization implementation
    fun initialize() {
        isInitialized = true
    }
}