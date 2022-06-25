package com.sophist.instr.helper

import android.os.Handler
import com.sophist.instr.helper.testapi.IExecute
import com.sophist.instr.helper.testapi.IShell
import com.sophist.instr.helper.testapi.ISleep
import com.sophist.instr.manager.ComponentManager
import com.sophist.instr.uiautomator.AutomationManager
import java.util.concurrent.Executors

/**
 * 测试基类，为测试case提供基本环境，比如断言、休眠、shell、线程任务等操作
 */
abstract class AbstractTestBase : IShell, IExecute, ISleep {

    /**
     * 执行adb命令，不需要返回结果
     * 1.优先使用UiAutomator实现，权限更高，事件注入和控件点击可操作
     * 2.备用方案使用Runtime.getRuntime，权限较低
     *
     * @param cmd cmd命令字符串
     */
    override fun exec(cmd: String?) {
        try {
            val uiDevice = AutomationManager.sUiDevice
            uiDevice.executeShellCommand(cmd)
        } catch (e: Exception) {
            InstrLog.error(e)
            InstrLog.error("execute with runtime")
            super.exec(cmd)
        }
    }

    /**
     * 执行adb命令，需要返回字符串结果
     * 1.优先使用UiAutomator实现，权限更高，事件注入和控件点击可操作
     * 2.备用方案使用Runtime.getRuntime，权限较低
     *
     * @param cmd 命令
     * @return
     */
    override fun execForResult(cmd: String?): String {
        val result: String = try {
            try {
                val uiDevice = AutomationManager.sUiDevice
                uiDevice.executeShellCommand(cmd)
            } catch (e: Exception) {
                InstrLog.error(e)
                InstrLog.error("execute with runtime")
                super.execForResult(cmd)
            }
        } catch (e: Exception) {
            InstrLog.error(e)
            ""
        }
        return result
    }

    /**
     * 建议使用的启动Activity的方法，不会频繁创建任务栈
     *
     * @param packageName 启动应用包名
     * @param activityName 启动Activity名
     */
    protected fun launchActivitySafely(packageName: String?, activityName: String?) {
        val cmdStr = String.format(
            "am start -a android.intent.action.VIEW -n %s/%s",
            packageName,
            activityName
        )
        InstrLog.info("launchActivitySafely $cmdStr")
        exec(cmdStr)
    }

    /**
     * 主线程执行任务
     * @param runnable 任务
     */
    override fun postTaskInMain(runnable: Runnable?) {
        Handler(ComponentManager.sAppContext.mainLooper).post(runnable!!)
    }

    /**
     * 线程池中执行任务
     * @param runnable 任务
     */
    override fun postTaskInExecutors(runnable: Runnable?) {
        sExecutorService.execute(runnable)
    }

    companion object {

        //线程池，是否需要增加线程池操作，被类公用
        private var sExecutorService = Executors.newFixedThreadPool(5)
    }
}