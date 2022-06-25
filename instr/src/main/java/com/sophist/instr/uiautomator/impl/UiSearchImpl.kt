package com.sophist.instr.uiautomator.impl

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import com.sophist.instr.uiautomator.AutomationManager
import com.sophist.instr.uiautomator.api.AbstractUiSearch

/**
 * Ui查找实现类
 */
class UiSearchImpl : AbstractUiSearch {

    override fun findView(selector: BySelector, timeout: Int): UiObject2? {
        var findObject : UiObject2? = null
        var retryCounts = timeout/AbstractUiSearch.DEFAULT_TIMEOUT
        while(findObject == null && retryCounts > 0) {
            findObject = AutomationManager.sUiDevice.findObject(selector)
            retryCounts--
        }
        return findObject
    }
}