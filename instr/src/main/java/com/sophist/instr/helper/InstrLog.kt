package com.sophist.instr.helper

import java.util.logging.Logger

object InstrLog {

    val logger : Logger by lazy {
        Logger.getLogger("InstrLog")
    }

    fun info(msg : String) = logger.info(msg)

    fun error(msg : String) = logger.warning(msg)

    fun error(throwable : Throwable) {
        val msg = "Throwable[${throwable.message}, ${throwable.cause}, ${throwable.stackTrace}]"
        error(msg)
    }
}