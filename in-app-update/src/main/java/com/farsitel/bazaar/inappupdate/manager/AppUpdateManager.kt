package com.farsitel.bazaar.inappupdate.manager

import android.app.Activity
import com.farsitel.bazaar.inappupdate.model.AppUpdateInfo
import com.farsitel.bazaar.inappupdate.callback.InstallStateUpdatedListener
import com.farsitel.bazaar.inappupdate.callback.task.Task
import com.farsitel.bazaar.inappupdate.install.InstallState
import com.farsitel.bazaar.inappupdate.model.UpdateType

interface AppUpdateManager {

    fun registerListener(listener: InstallStateUpdatedListener)
    fun registerListener(onStateChange: (InstallState) -> Unit)
    fun unregisterListener()
    fun getAppUpdateInfo(): Task<AppUpdateInfo>
    fun startUpdateFlow(
        appUpdateInfo: AppUpdateInfo,
        updateType: UpdateType,
        activity: Activity
    )

    fun startUpdateFlowForResult(
        appUpdateInfo: AppUpdateInfo,
        updateType: UpdateType,
        activity: Activity,
        requestCode: Int
    )

    fun completeUpdate()
}