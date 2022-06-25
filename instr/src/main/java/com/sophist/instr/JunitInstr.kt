package com.sophist.instr

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.sophist.instr.helper.InstrLog
import com.sophist.instr.helper.JunitInstrRunListener

/**
 * 基于AndroidJunitRunner的instrumentation方式
 */
class JunitInstr : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        arguments?.let {
            // 将要增加的监听器写入配置
            it.putString("listener", JunitInstrRunListener::class.java.canonicalName)
        }
        //注意在super.onCreate就会完成pareseAguments，如果要增加自定义参数，需要在此之前
        super.onCreate(arguments)
        InstrLog.info("JunitInstr--onCreate...")
    }

    override fun onStart() {
        super.onStart()
        InstrLog.info("JunitInstr--onStart...")
    }

    override fun start() {
        super.start()
        InstrLog.info("JunitInstr--start...")
    }

    override fun onDestroy() {
        super.onDestroy()
        InstrLog.info("JunitInstr--onDestroy...")
    }
}