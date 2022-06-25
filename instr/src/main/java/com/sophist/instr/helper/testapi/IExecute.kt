package com.sophist.instr.helper.testapi

/**
 * 线程池调度接口
 */
interface IExecute {
    /**
     * 在主线程执行任务 [runnable] 任务
     */
    fun postTaskInMain(runnable: Runnable?)

    /**
     * 在子线程执行任务 [runnable] 任务
     */
    fun postTaskInExecutors(runnable: Runnable?)
}
