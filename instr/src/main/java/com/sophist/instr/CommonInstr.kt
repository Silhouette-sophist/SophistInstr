package com.sophist.instr

import android.app.Instrumentation
import android.os.Bundle
import androidx.test.platform.app.InstrumentationRegistry

/**
 * 继承自底层的Instrumentation
 */
class CommonInstr : Instrumentation() {

    /**
     * 生命周期：Instr.onCreate-->Application.onCreate-->Instr.onStart-->Instr.start
     * 除了start其余都是主线程执行
     */
    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)

        // 参考AndroidJunit模式，注册当前Instrumentation
        InstrumentationRegistry.registerInstance(this, arguments)
    }


    override fun onStart() {
        super.onStart()
    }

    /**
     * Instr测试会在InstrumentationThread线程中开始测试
     */
    override fun start() {
        super.start()
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}