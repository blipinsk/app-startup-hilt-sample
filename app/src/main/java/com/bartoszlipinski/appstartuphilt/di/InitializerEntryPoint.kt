package com.bartoszlipinski.appstartuphilt.di

import android.content.Context
import com.bartoszlipinski.appstartuphilt.initializer.AnalyticsInitializer
import com.bartoszlipinski.appstartuphilt.initializer.BugReportingInitializer
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface InitializerEntryPoint {

    companion object {
        fun resolve(context: Context): InitializerEntryPoint {
            val appContext = context.applicationContext ?: throw IllegalStateException()
            return EntryPointAccessors.fromApplication(
                appContext,
                InitializerEntryPoint::class.java
            )
        }
    }

    fun inject(initializer: AnalyticsInitializer)

    fun inject(initializer: BugReportingInitializer)
}
