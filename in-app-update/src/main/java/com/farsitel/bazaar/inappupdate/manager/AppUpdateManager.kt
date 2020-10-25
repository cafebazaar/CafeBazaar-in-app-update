package com.farsitel.bazaar.inappupdate.manager

import android.app.Activity
import android.content.Context
import com.farsitel.bazaar.inappupdate.model.AppUpdateInfo
import com.farsitel.bazaar.inappupdate.callback.InstallStateUpdatedListener
import com.farsitel.bazaar.inappupdate.callback.task.Task
import com.farsitel.bazaar.inappupdate.connection.ReceiverConnection
import com.farsitel.bazaar.inappupdate.install.InstallState
import com.farsitel.bazaar.inappupdate.model.UpdateType

abstract class AppUpdateManager {

    private var installStateListener: InstallStateUpdatedListener? = null
    private var stateChangeCallback: ((InstallState) -> Unit)? = null

    abstract fun getAppUpdateInfo(): Task<AppUpdateInfo>
    abstract fun startUpdateFlow(
        appUpdateInfo: AppUpdateInfo,
        updateType: UpdateType,
        activity: Activity
    )

    abstract fun startUpdateFlowForResult(
        appUpdateInfo: AppUpdateInfo,
        updateType: UpdateType,
        activity: Activity,
        requestCode: Int
    )

    abstract fun completeUpdate()

    fun registerListener(listener: InstallStateUpdatedListener) {
        installStateListener = listener
    }

    fun registerListener(onStateChange: (InstallState) -> Unit) {
        stateChangeCallback = onStateChange
    }

    fun unregisterListener() {
        stateChangeCallback = null
        installStateListener = null
    }
}