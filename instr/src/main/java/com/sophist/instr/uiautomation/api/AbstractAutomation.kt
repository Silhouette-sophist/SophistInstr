package com.sophist.instr.uiautomation.api

import android.app.UiAutomation
import android.graphics.Bitmap
import android.os.ParcelFileDescriptor
import android.view.InputEvent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo


interface AbstractAutomation {

    //1.设置Accessibility事件监听
    fun setOnAccessibilityEventListener(listener : UiAutomation.OnAccessibilityEventListener)

    //2.控制shell权限

    //3.全局事件注入，如全局返回、home等

    fun performAction(action : Int) : Boolean

    //4.查找焦点

    //5.获取辅助服务信息

    //6.获取所有窗口给，getWindows()和getRootInActiveWindow()
    fun getWindows() : List<AccessibilityWindowInfo>

    fun getRootInActiveWindow() : AccessibilityNodeInfo

    fun getTotalAccessibilityNodes(restrictClickable : Boolean) : List<AccessibilityNodeInfo>

    //7.注入事件
    fun injectEvent(event : InputEvent, sync : Boolean) : Boolean

    //8.文本输入事件

    //9.旋转屏幕
    fun setRotation(rotation : Int) : Boolean

    //10.执行任务并等待特定Ui事件回调，等待ui事件空闲
    fun executeAndWaitForEvent(runnable: Runnable, filter: UiAutomation.AccessibilityEventFilter, timeoutMills : Long) : AccessibilityEvent

    //11.截图，指定窗口截图
    fun takeScreenshot() : Bitmap

    //12.设置Monkey运行模式

    //13.清除或获取窗口中帧信息，或者动画帧信息

    //14.准许和收回Runtime权限

    //15.执行shell命令
    fun executeShellCommand(command : String) : ParcelFileDescriptor

}