package com.bartoszlipinski.appstartuphilt.initializer

import android.content.Context
import androidx.startup.Initializer
import com.bartoszlipinski.appstartuphilt.di.BugReportingService
import com.bartoszlipinski.appstartuphilt.di.InitializerEntryPoint
import javax.inject.Inject

class BugReportingInitializer : Initializer<BugReportingService> {

    @Inject
    lateinit var bugReportingService: BugReportingService

    override fun create(context: Context): BugReportingService {
        //injecting dependencies from Hilt
        InitializerEntryPoint.resolve(context).inject(this)

        //performing the initialization
        bugReportingService.initialize()

        return bugReportingService
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        //requires Dependency Graph to be initialized
        return listOf(DependencyGraphInitializer::class.java)
    }
}