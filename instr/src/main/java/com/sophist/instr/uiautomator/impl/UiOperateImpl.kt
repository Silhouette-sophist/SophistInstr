package com.sophist.instr.uiautomator.impl

import androidx.test.uiautomator.BySelector
import com.sophist.instr.uiautomator.api.AbstractUiOperate
import com.sophist.instr.uiautomator.api.AbstractUiSearch

/**
 * Ui操作实现类
 */
class UiOperateImpl : AbstractUiOperate {

    // Ui操作依赖于Ui查找
    val abstractUiSearch : AbstractUiSearch by lazy {
        UiSearchImpl()
    }

    /**
     * 点击控件[selector] 选择器， [timeout] 超时时间
     */
    override fun clickView(selector: BySelector, timeout: Int) : Boolean {
        val findView = abstractUiSearch.findView(selector, timeout)
        return if(findView != null) {
            findView.click()
            true
        } else {
            false
        }
    }
}