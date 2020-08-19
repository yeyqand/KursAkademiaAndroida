package com.yeyq.kursakademiaandroida.utils

import androidx.arch.core.executor.TaskExecutor

object FakeMainThreadExecutor : TaskExecutor() {
    override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

    override fun isMainThread() = true

    override fun postToMainThread(runnable: Runnable) = runnable.run()
}