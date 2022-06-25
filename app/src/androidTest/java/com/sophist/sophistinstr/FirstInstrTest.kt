package com.sophist.sophistinstr

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sophist.instr.helper.AbstractTestBase
import com.sophist.instr.helper.InstrLog
import com.sophist.instr.uiautomation.impl.AutomationImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FirstInstrTest : AbstractTestBase() {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.sophist.sophistinstr", appContext.packageName)


        val abstractAutomation = AutomationImpl()
        val takeScreenshot = abstractAutomation.takeScreenshot()

        println("takeScreenshot $takeScreenshot")

        val result = execForResult("ps -A")
        InstrLog.info(result)
    }
}