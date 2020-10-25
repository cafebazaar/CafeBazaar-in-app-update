package com.farsitel.bazaar.inappupdate.connection

import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode

internal interface BazaarConnectionCallback {
    fun onGetUpdateInfo(versionCode: Int) {}
    fun onGetUpdateInfoFailure(errorCode: InstallErrorCode) {}
}