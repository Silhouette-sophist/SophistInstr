package com.sophist.instr.helper

import org.junit.runner.Description
import org.junit.runner.Result
import org.junit.runner.notification.Failure
import org.junit.runner.notification.RunListener

class JunitInstrRunListener : RunListener() {

    override fun testRunStarted(description: Description?) {
        super.testRunStarted(description)
        InstrLog.info("testRunStarted...$description")
    }

    override fun testRunFinished(result: Result?) {
        super.testRunFinished(result)
        InstrLog.info("testRunFinished...$result")
    }

    override fun testStarted(description: Description?) {
        super.testStarted(description)
        InstrLog.info("testStarted...$description")
    }

    override fun testFinished(description: Description?) {
        super.testFinished(description)
        InstrLog.info("testFinished...$description")
    }

    override fun testFailure(failure: Failure?) {
        super.testFailure(failure)
        InstrLog.info("testFailure...$failure")
    }

    override fun testAssumptionFailure(failure: Failure?) {
        super.testAssumptionFailure(failure)
        InstrLog.info("testAssumptionFailure...$failure")
    }

    override fun testIgnored(description: Description?) {
        super.testIgnored(description)
        InstrLog.info("testIgnored...$description")
    }
}