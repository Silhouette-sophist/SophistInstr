package com.sophist.instr.uiautomator.api

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector

/**
 * UI操作相关
 */
interface AbstractUiOperate {

    /**
     * 通过BySelector点击控件，基于UiAutomator服务
     * 基本api
     */
    fun clickView(selector: BySelector, timeout : Int = AbstractUiSearch.DEFAULT_TIMEOUT) : Boolean

    /**
     * 通过控件text字段匹配[text]点击控件
     */
    fun clickViewByText(text : String, timeout: Int = AbstractUiSearch.DEFAULT_TIMEOUT) = clickView(By.text(text), timeout)

    /**
     * 通过控件text字段匹配以[subText]开头点击控件
     */
    fun clickViewByTextStartWith(subText : String, timeout: Int = AbstractUiSearch.DEFAULT_TIMEOUT) = clickView(By.textStartsWith(subText), timeout)

    /**
     * 通过控件text字段匹配以[subText]结尾点击控件
     */
    fun clickViewByTextEndWith(subText: String, timeout: Int = AbstractUiSearch.DEFAULT_TIMEOUT) = clickView(By.textEndsWith(subText), timeout)

    /**
     * 通过控件text字段匹配包含[subText]点击控件
     */
    fun clickViewByTextContain(subText: String, timeout: Int = AbstractUiSearch.DEFAULT_TIMEOUT) = clickView(By.textContains(subText), timeout)
}