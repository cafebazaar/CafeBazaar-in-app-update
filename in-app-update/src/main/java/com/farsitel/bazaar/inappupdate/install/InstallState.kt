package com.farsitel.bazaar.inappupdate.install

import com.farsitel.bazaar.inappupdate.exception.InstallErrorCode

interface InstallState {
    val installStatus: InstallStatus
    val bytesDownloaded: Long
    val totalBytesToDownload: Long
    val installErrorCode: InstallErrorCode
    val packageName: String
}