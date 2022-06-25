package com.sophist.instr.uiautomator.api

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2

/**
 * UI控件查找相关
 */
interface AbstractUiSearch {

    companion object {
        // 查询控件默认时间500ms
        const val DEFAULT_TIMEOUT = 500
    }

    /**
     * 通过BySelector查找控件，基于UiAutomator服务
     * 基本api
     */
    fun findView(selector: BySelector, timeout : Int = DEFAULT_TIMEOUT) : UiObject2?

    /**
     * 完全匹配控件的[text]字段
     */
    fun findViewByText(text : String, timeout : Int = DEFAULT_TIMEOUT) = findView(By.text(text), timeout)

    /**
     * 控件text字段以[subText]开始
     */
    fun findViewByTextStartWith(subText : String, timeout : Int = DEFAULT_TIMEOUT) = findView(By.textStartsWith(subText), timeout)

    /**
     * 控件text字段以[subText]结尾
     */
    fun findViewByTextEndWith(subText: String, timeout : Int = DEFAULT_TIMEOUT) = findView(By.textEndsWith(subText), timeout)

    /**
     * 控件text字段包含[subText]
     */
    fun findViewByTextContains(subText: String, timeout : Int = DEFAULT_TIMEOUT) = findView(By.textContains(subText), timeout)
}