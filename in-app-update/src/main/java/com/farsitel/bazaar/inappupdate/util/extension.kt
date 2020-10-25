package com.farsitel.bazaar.inappupdate.util

import android.content.Context
import android.content.Intent

fun Intent.isAbleToLaunch(context: Context): Boolean {
    return try {
        resolveActivity(context.packageManager) != null
    } catch (exception: Exception) {
        InAppUpdateLogger.logError("activity not found to handle intent")
        false
    }
}