package com.farsitel.bazaar.inappupdate.manager

import android.app.Activity
import android.content.Context
import com.farsitel.bazaar.inappupdate.model.AppUpdateInfo
import com.farsitel.bazaar.inappupdate.callback.InstallStateUpdatedListener
import com.farsitel.bazaar.inappupdate.callback.task.Task
import com.farsitel.bazaar.inappupdate.install.InstallState
import com.farsitel.bazaar.inappupdate.model.UpdateType

class FakeUpdateManager(private val context: Context) : AppUpdateManager {

    override fun registerListener(listener: InstallStateUpdatedListener) {
        TODO("Not yet implemented")
    }

    override fun registerListener(onStateChange: (InstallState) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun unregisterListener() {
        TODO("Not yet implemented")
    }

    override fun getAppUpdateInfo(): Task<AppUpdateInfo> {
        TODO("Not yet implemented")
    }

    override fun startUpdateFlow(
        appUpdateInfo: AppUpdateInfo,
        updateType: UpdateType,
        activity: Activity
    ) {
        TODO("Not yet implemented")
    }

    override fun startUpdateFlowForResult(
        appUpdateInfo: AppUpdateInfo,
        updateType: UpdateType,
        activity: Activity,
        requestCode: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun completeUpdate() {
        TODO("Not yet implemented")
    }
}