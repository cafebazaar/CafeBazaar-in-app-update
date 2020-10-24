package com.farsitel.bazaar.inappupdate

import android.content.Context
import com.farsitel.bazaar.inappupdate.security.Security.verifyBazaarIsInstalled
import com.farsitel.bazaar.inappupdate.util.getPackageInfo
import com.farsitel.bazaar.inappupdate.util.versionCodeSDKAware

object BazaarClientProxy {

    private const val BAZAAR_WITH_IN_APP_UPDATE_VERSION = 902200

    fun isBazaarInstalledOnDevice(context: Context): Boolean {
        return getPackageInfo(context, BAZAAR_PACKAGE_NAME) != null &&
                verifyBazaarIsInstalled(context)
    }

    fun isNeededToUpdateBazaar(context: Context): Boolean {
        return getBazaarVersion(context) < BAZAAR_WITH_IN_APP_UPDATE_VERSION
    }

    private fun getBazaarVersion(context: Context): Long {
        return getPackageInfo(context, BAZAAR_PACKAGE_NAME)?.versionCodeSDKAware ?: -1
    }
}