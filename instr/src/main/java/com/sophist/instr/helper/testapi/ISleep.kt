package com.sophist.instr.helper.testapi

import android.os.SystemClock

/**
 * 支持休眠操作接口
 */
interface ISleep {
    /**
     * 休眠指定时长，不可中断
     * [time] 休眠时间
     */
    fun waitForTime(time: Long) {
        SystemClock.sleep(time)
    }
}