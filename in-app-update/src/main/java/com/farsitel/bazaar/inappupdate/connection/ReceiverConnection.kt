package com.farsitel.bazaar.inappupdate.connection

import android.content.Context
import android.content.Intent
import com.farsitel.bazaar.inappupdate.BAZAAR_PACKAGE_NAME

internal class ReceiverConnection(private val context: Context) {


    private fun createIntentForBroadcast(action: String) = Intent().apply {
        setPackage(BAZAAR_PACKAGE_NAME)
        setAction(action)
        putExtra(PACKAGE_NAME_KEY, context.packageName)
    }

    companion object {
        const val PACKAGE_NAME_KEY = "packageName"
    }
}