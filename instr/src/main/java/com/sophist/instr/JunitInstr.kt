package com.sophist.instr

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.sophist.instr.helper.InstrLog

/**
 * 基于AndroidJunitRunner的instrumentation方式
 */
class JunitInstr : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
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