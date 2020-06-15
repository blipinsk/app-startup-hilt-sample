package com.bartoszlipinski.appstartuphilt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bartoszlipinski.appstartuphilt.di.AnalyticsService
import com.bartoszlipinski.appstartuphilt.di.BugReportingService
import com.bartoszlipinski.appstartuphilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var analyticsService: AnalyticsService

    @Inject
    lateinit var bugReportingService: BugReportingService

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text.text = prepareAnalyticsText() + "\n" + prepareBugReportingText()
    }

    private fun prepareAnalyticsText() =
        "Analytics is initialized = ${analyticsService.isInitialized}"

    private fun prepareBugReportingText() =
        "BugReporting is initialized = ${bugReportingService.isInitialized}"
}