package com.farsitel.bazaar.inappupdate.callback.task

import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode
import com.farsitel.bazaar.inappupdate.model.AppUpdateInfo

class UpdateInfoTask : Task<AppUpdateInfo> {

    private var isComplete: Boolean = false
    private var isSuccessful: Boolean = false
    private var onSuccessListener: OnSuccessListener<AppUpdateInfo>? = null
    private var onSuccess: ((AppUpdateInfo) -> Unit)? = null
    private var onCompleteListener: OnCompleteListener<AppUpdateInfo>? = null
    private var onComplete: ((AppUpdateInfo) -> Unit)? = null
    private var onFailureListener: OnFailureListener? = null
    private var onFailure: ((InstallErrorCode) -> Unit)? = null
    private var exception: Exception? = null
    private var appUpdateInfo = AppUpdateInfo()

    override fun getResult(): AppUpdateInfo {
        if (!isComplete) {
            throw IllegalStateException("task is not complete")
        }
        if (!isSuccessful) {
            throw RuntimeException("task failed with an exception")
        } else {
            return appUpdateInfo
        }
    }

    fun setTaskSucceed() {
        isSuccessful = true
        onSuccess?.invoke(appUpdateInfo)
        onSuccessListener?.onSuccess(appUpdateInfo)
    }

    fun setTaskCompleted() {
        isComplete = true
        onComplete?.invoke(appUpdateInfo)
        onCompleteListener?.onComplete(appUpdateInfo)
    }

    fun setTaskFailed(errorCode: InstallErrorCode) {
        isSuccessful = false
        onFailure?.invoke(errorCode)
        onFailureListener?.onFailure(errorCode)
    }

    fun updateInfo(changes: AppUpdateInfo.() -> Unit) {
        appUpdateInfo.changes()
    }

    override fun getException(): Exception? {
        return exception
    }

    override fun isSuccessful(): Boolean {
        return isSuccessful
    }

    override fun isComplete(): Boolean {
        return isComplete
    }

    override fun addOnSuccessListener(onSuccessListener: OnSuccessListener<AppUpdateInfo>) {
        this.onSuccessListener = onSuccessListener
    }

    override fun addOnFailureListener(onFailureListener: OnFailureListener) {
        this.onFailureListener = onFailureListener
    }

    override fun addOnCompleteListener(onCompleteListener: OnCompleteListener<AppUpdateInfo>) {
        this.onCompleteListener = onCompleteListener
    }

    override fun addOnSuccessListener(onSuccess: (AppUpdateInfo) -> Unit) {
        this.onSuccess = onSuccess
    }

    override fun addOnFailureListener(onFailure: (InstallErrorCode) -> Unit) {
        this.onFailure = onFailure
    }

    override fun addOnCompleteListener(onComplete: (AppUpdateInfo) -> Unit) {
        this.onComplete = onComplete
    }
}