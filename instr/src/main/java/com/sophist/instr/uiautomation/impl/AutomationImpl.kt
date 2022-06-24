package com.sophist.instr.uiautomation.impl

import android.app.UiAutomation
import android.os.ParcelFileDescriptor
import android.view.InputEvent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo
import com.sophist.instr.manager.ComponentManager
import com.sophist.instr.uiautomation.api.AbstractAutomation

class AutomationImpl : AbstractAutomation {

    val sAutomation : UiAutomation by lazy {
        ComponentManager.sInstrumentation.uiAutomation
    }

    override fun setOnAccessibilityEventListener(listener: UiAutomation.OnAccessibilityEventListener) {
        sAutomation.setOnAccessibilityEventListener(listener)
    }

    override fun performAction(action: Int) = sAutomation.performGlobalAction(action)

    override fun getWindows(): List<AccessibilityWindowInfo> = sAutomation.windows

    override fun getRootInActiveWindow(): AccessibilityNodeInfo = sAutomation.rootInActiveWindow

    override fun getTotalAccessibilityNodes(restrictClickable: Boolean): List<AccessibilityNodeInfo> {
        val totalNodes = ArrayList<AccessibilityNodeInfo>()
        totalNodes.add(sAutomation.rootInActiveWindow)
        sAutomation.windows.forEach { windowInfo ->
            windowInfo?.let {
                obtainNodeInfo(windowInfo.root, container = totalNodes, restrictClickable)
            }
        }
        return totalNodes
    }

    fun getTotalAccessibilityNodes(): List<AccessibilityNodeInfo> = getTotalAccessibilityNodes(restrictClickable = false)

    fun obtainNodeInfo(rootNode : AccessibilityNodeInfo, container : ArrayList<AccessibilityNodeInfo>, restrictClickable: Boolean = false) {
        if (!restrictClickable || rootNode.isClickable) {
            container.add(rootNode)
        }
        var childCount = rootNode.childCount
        while(childCount > 0) {
            obtainNodeInfo(rootNode.getChild(rootNode.childCount - childCount), container, restrictClickable)
            childCount--
        }
    }

    override fun injectEvent(
        event: InputEvent,
        sync: Boolean
    ): Boolean = sAutomation.injectInputEvent(event, sync)

    override fun setRotation(rotation: Int): Boolean = sAutomation.setRotation(rotation)

    override fun executeAndWaitForEvent(
        runnable: Runnable,
        filter: UiAutomation.AccessibilityEventFilter,
        timeoutMills: Long
    ): AccessibilityEvent = sAutomation.executeAndWaitForEvent(runnable, filter, timeoutMills)

    override fun takeScreenshot() = sAutomation.takeScreenshot()

    override fun executeShellCommand(command: String): ParcelFileDescriptor = sAutomation.executeShellCommand(command)
}