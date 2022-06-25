package com.sophist.instr.uiautomator.api

import android.graphics.Bitmap
import android.graphics.Rect

/**
 * 截屏相关
 */
interface AbstractScreenCapture {

    /**
     * 指定区域截图
     */
    fun captureScreen(rect : Rect? = null, appendMsg : String? = null) : Bitmap

    /**
     * 在指定文件夹下保存指定截图文件，并支持指定截图区域
     */
    fun saveScreenCapture(directory : String? = null, fileName : String? = null, rect : Rect? = null, appendMsg : String? = null) : Boolean
}