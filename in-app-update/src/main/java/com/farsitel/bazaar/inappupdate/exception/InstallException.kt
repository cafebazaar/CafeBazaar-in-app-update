package com.farsitel.bazaar.inappupdate.exception

class InstallException(private val errorCode: InstallErrorCode) : RuntimeException() {
    override val message: String?
        get() = errorCode.message
}
