package com.sophist.sophistinstr

import android.app.Application
import java.util.logging.Logger

class SophistInstrApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.getLogger("InstrLog").info("SophistInstrApp--onCreate...")
    }
}