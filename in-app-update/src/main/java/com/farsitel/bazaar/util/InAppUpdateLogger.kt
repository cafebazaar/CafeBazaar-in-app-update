package com.farsitel.bazaar.util

import android.util.Log

internal object InAppUpdateLogger {

    var debugLog = false
    private const val DEBUG_TAG = "BazaarInAppUpdate"

    fun logDebug(msg: String) {
        if (debugLog) {
            Log.d(DEBUG_TAG, msg)
        }
    }

    fun logError(msg: String?) {
        Log.e(DEBUG_TAG, "In-app update error: $msg")
    }

    fun logWarn(msg: String) {
        Log.w(DEBUG_TAG, "In-app update warning: $msg")
    }
}