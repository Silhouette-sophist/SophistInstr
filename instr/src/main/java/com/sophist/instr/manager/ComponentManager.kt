package com.sophist.instr.manager

import android.app.Instrumentation
import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry

/**
 * 提供基本系统组件环境
 */
object ComponentManager {

    // 持有的Instrumentation
    val sInstrumentation: Instrumentation by lazy {
        InstrumentationRegistry.getInstrumentation()
    }

    // 被测宿主的Context，注意属于非Activity、Service和Application等，普通后台Context
    val sAppContext : Context by lazy {
        sInstrumentation.targetContext
    }

    // 测试app的Context，同样是普通后台Context
    val sInstrContext : Context by lazy {
        sInstrumentation.context
    }
}