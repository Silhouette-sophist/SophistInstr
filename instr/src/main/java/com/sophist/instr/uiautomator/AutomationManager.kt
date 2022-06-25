package com.sophist.instr.uiautomator

import android.app.Instrumentation
import android.app.UiAutomation
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice

/**
 * 持有AndroidTest测试相关的系统组件：
 * - 被测宿主：Context
 * - 测试应用：Instrumentation，Context
 *
 * 优先级：UiDevice>UiAutomation
 * 问题：UiDevice基于UiAutomator服务，容易出现问题。而UiAutomation则是基于Instrumentation，属于系统api，不容易出现问题
 */
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