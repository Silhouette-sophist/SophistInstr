package com.sophist.instr.helper.testapi

import android.text.TextUtils
import com.sophist.instr.helper.InstrLog
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 执行cmd命令的接口，带有默认Runtime的实现
 */
interface IShell {
    /**
     * 执行ShellInterface的回调接口
     */
    interface ICallback {
        fun onSuccess(msg: String?)
        fun onFailed(throwable: Throwable?)
    }

    /**
     * 执行cmd命令，等待结果回调
     * Runtime默认实现，权限没有Uiautomator实现高
     * 子类最好重新实现
     * [cmd]adb命令， [callback] 执行回调
     */
    fun exec(cmd: String?, callback: ICallback?) {
        val stringBuilder = StringBuilder()
        if (cmd != null && !TextUtils.isEmpty(cmd)) {
            try {
                val exec = Runtime.getRuntime().exec(cmd)
                exec.waitFor()
                val bufferedReader = BufferedReader(InputStreamReader(exec.inputStream))
                var readString: String
                while (bufferedReader.readLine().also { readString = it } != null) {
                    stringBuilder.append(
                        """
                            $readString
                            
                            """.trimIndent()
                    )
                }
                callback?.onSuccess(stringBuilder.toString())
            } catch (e: Exception) {
                InstrLog.error(e)
                callback?.onFailed(e)
            }
        }
    }

    /**
     * 执行cmd命令，并等待结果返回
     * Runtime默认实现，权限没有Uiautomator实现高
     * 子类最好重新实现
     * [cmd]adb命令
     */
    fun execForResult(cmd: String?): String {
        val stringBuilder = StringBuilder()
        if (cmd != null && !TextUtils.isEmpty(cmd)) {
            try {
                val exec = Runtime.getRuntime().exec(cmd)
                exec.waitFor()
                val bufferedReader = BufferedReader(InputStreamReader(exec.inputStream))
                var readString: String?
                while (bufferedReader.readLine().also { readString = it } != null) {
                    stringBuilder.append(readString)
                }
            } catch (e: Exception) {
                InstrLog.error(e)
                stringBuilder.append("execForResult error")
            }
        }
        return stringBuilder.toString()
    }

    /**
     * 执行cmd命令，并等待结果返回
     * [args] 拆分后的adb命令
     */
    fun execForResult(args: List<String?>?): String? {
        return if (args != null && args.isNotEmpty()) {
            execForResult(TextUtils.join(" ", args))
        } else ""
    }

    /**
     * 执行cmd命令，不等待结果返回
     * Runtime默认实现，权限没有Uiautomator实现高
     *  [cmd] adb 命令
     */
    fun exec(cmd: String?) {
        if (cmd != null && !TextUtils.isEmpty(cmd)) {
            exec(cmd, null)
        }
    }
}