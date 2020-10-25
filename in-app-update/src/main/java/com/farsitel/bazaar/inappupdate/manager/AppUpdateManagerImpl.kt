package com.farsitel.bazaar.inappupdate.manager

import android.app.Activity
import android.content.Context
import com.farsitel.bazaar.inappupdate.model.AppUpdateInfo
import com.farsitel.bazaar.inappupdate.callback.task.Task
import com.farsitel.bazaar.inappupdate.callback.task.UpdateInfoTask
import com.farsitel.bazaar.inappupdate.connection.BazaarConnectionCallback
import com.farsitel.bazaar.inappupdate.connection.ReceiverConnection
import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode
import com.farsitel.bazaar.inappupdate.install.InstallStatus
import com.farsitel.bazaar.inappupdate.model.UpdateType

class AppUpdateManagerImpl(context: Context) : AppUpdateManager(), BazaarConnectionCallback {

    private var connection: ReceiverConnection = ReceiverConnection.getInstance(context)
    private lateinit var updateTask: UpdateInfoTask

    override fun getAppUpdateInfo(): Task<AppUpdateInfo> {
        initUpdate()
        connection.getAppUpdateInfo()
        return updateTask
    }

    private fun initUpdate() {
        connection.setCallback(this)
        updateTask = UpdateInfoTask()
        updateTask.updateInfo {
            setInstallStatus(InstallStatus.PENDING)
        }
    }

    override fun onGetUpdateInfo(versionCode: Int) {
        updateTask.updateInfo {
            setAvailableVersionCode(versionCode)
        }
        updateTask.setTaskSucceed()
        updateTask.setTaskCompleted()
    }

    override fun onGetUpdateInfoFailure(errorCode: InstallErrorCode) {
        updateTask.setTaskFailed(errorCode)
        updateTask.setTaskCompleted()
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