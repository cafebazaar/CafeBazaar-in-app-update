package com.farsitel.bazaar.inappupdate.connection

import android.os.Bundle
import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode

object ReceiverDataHandler {

    private const val KEY_IAU_STATUS: String = "iauStatus"
    private const val KEY_IAU_SUCCESS: Int = 0
    private const val KEY_IAU_FAILED: Int = -1

    private const val KEY_IAU_UPDATE_VERSION_CODE: String = "versionCode"

    fun isSuccessful(extras: Bundle): Boolean {
        return extras.getInt(KEY_IAU_STATUS) == KEY_IAU_SUCCESS
    }

    fun getFailureCode(extras: Bundle): InstallErrorCode {
        val code = extras.getInt(KEY_IAU_STATUS)
        return InstallErrorCode.errorCodeToEnum(code)
    }

    fun getVersionCodeFromInfo(extras: Bundle): Int {
        return extras.getInt(KEY_IAU_UPDATE_VERSION_CODE, -1)
    }
}