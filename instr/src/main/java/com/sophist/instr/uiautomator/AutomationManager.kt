package com.sophist.instr.uiautomator

import android.app.Instrumentation
import android.app.UiAutomation
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice

object AutomationManager {

    val sInstrumentation : Instrumentation by lazy {
        InstrumentationRegistry.getInstrumentation()
    }

    // 方式一：直接使用三方模块UiAutomator
    val sUiDevice : UiDevice by lazy {
        UiDevice.getInstance(sInstrumentation)
    }

    // 方式二：直接使用Instrumentation.Automation
    val sUiAutomation : UiAutomation by lazy {
        sInstrumentation.uiAutomation
    }
}