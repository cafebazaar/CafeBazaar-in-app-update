package com.farsitel.bazaar.inappupdate.model

import com.farsitel.bazaar.inappupdate.install.InstallStatus

class AppUpdateInfo {

    private var installStatus: InstallStatus = InstallStatus.UNKNOWN
    private var versionCode: Int = -1

    fun setAvailableVersionCode(versionCode: Int) {
        this.versionCode = versionCode
    }

    fun setInstallStatus(installStatus: InstallStatus) {
        this.installStatus = installStatus
    }

    fun installStatus(): InstallStatus = installStatus

    fun bytesDownloaded(): Long {
        TODO("Not yet implemented")
    }

    fun totalBytesToDownload(): Long {
        TODO("Not yet implemented")
    }

    fun availableVersionCode(): Int = versionCode

    fun isUpdateTypeAllowed(updateType: UpdateType): Boolean {
        TODO("Not yet implemented")
    }

    fun updateAvailability(): Int {
        TODO("Not yet implemented")
    }
}