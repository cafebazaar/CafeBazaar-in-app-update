package com.farsitel.bazaar.inappupdate

import android.content.Context
import com.farsitel.bazaar.inappupdate.manager.AppUpdateManager
import com.farsitel.bazaar.inappupdate.manager.AppUpdateManagerImpl

class AppUpdateManagerFactory {

    companion object {
        fun create(context: Context): AppUpdateManager {
            return AppUpdateManagerImpl(context)
        }
    }
}