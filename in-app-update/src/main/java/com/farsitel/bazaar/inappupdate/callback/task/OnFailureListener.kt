package com.farsitel.bazaar.inappupdate.callback.task

import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode

interface OnFailureListener {
    fun onFailure(errorCode: InstallErrorCode)
}