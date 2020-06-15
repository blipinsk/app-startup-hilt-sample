package com.bartoszlipinski.appstartuphilt.initializer

import android.content.Context
import androidx.startup.Initializer
import com.bartoszlipinski.appstartuphilt.di.InitializerEntryPoint

class DependencyGraphInitializer : Initializer<Unit> {

    override fun create(context: Context): Unit {
        //this will lazily initialize ApplicationComponent before Application's `onCreate`
        InitializerEntryPoint.resolve(context)
        return Unit
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}