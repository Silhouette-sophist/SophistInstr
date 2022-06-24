package com.sophist.instr

import android.os.Bundle
import android.util.Log
import androidx.test.runner.AndroidJUnitRunner

class JunitInstr : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        Log.d("JunitInstr", "JunitInstr---onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("JunitInstr", "JunitInstr---onStart")
    }

    override fun start() {
        super.start()
        Log.d("JunitInstr", "JunitInstr---start")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("JunitInstr", "JunitInstr---onDestroy")
    }
}