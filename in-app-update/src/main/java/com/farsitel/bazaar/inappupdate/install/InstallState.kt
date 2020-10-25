package com.farsitel.bazaar.inappupdate.install

import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode

interface InstallState {
    fun installStatus(): InstallStatus
    fun bytesDownloaded(): Long
    fun totalBytesToDownload(): Long
    fun installErrorCode(): InstallErrorCode
}