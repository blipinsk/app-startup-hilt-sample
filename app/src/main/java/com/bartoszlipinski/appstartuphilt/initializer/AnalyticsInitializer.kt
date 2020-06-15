package com.bartoszlipinski.appstartuphilt.initializer

import android.content.Context
import androidx.startup.Initializer
import com.bartoszlipinski.appstartuphilt.di.AnalyticsService
import com.bartoszlipinski.appstartuphilt.di.InitializerEntryPoint
import javax.inject.Inject

class AnalyticsInitializer : Initializer<AnalyticsService> {

    @Inject
    lateinit var analyticsService: AnalyticsService

    override fun create(context: Context): AnalyticsService {
        //injecting dependencies from Hilt
        InitializerEntryPoint.resolve(context).inject(this)

        //performing the initialization
        analyticsService.initialize()

        return analyticsService
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        //requires Dependency Graph to be initialized
        return listOf(DependencyGraphInitializer::class.java)
    }
}