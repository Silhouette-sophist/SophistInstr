package com.sophist.sophistinstr

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sophist.instr.uiautomation.impl.AutomationImpl
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.IllegalStateException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SecondInstrTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.sophist.sophistinstr", appContext.packageName)


        val abstractAutomation = AutomationImpl()
        val takeScreenshot = abstractAutomation.takeScreenshot()

        throw IllegalStateException("custom...")
    }
}