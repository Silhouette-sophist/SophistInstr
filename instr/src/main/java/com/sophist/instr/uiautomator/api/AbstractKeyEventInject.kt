package com.sophist.instr.uiautomator.api

/**
 * 全局事件注入，比如home、back、滑动等
 */
interface AbstractKeyEventInject {

    fun pressHome()

    fun pressBack()
}