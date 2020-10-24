package com.farsitel.bazaar.inappupdate.exception

enum class InstallErrorCode {

    /** The API is not available on this device.  */
    ERROR_API_NOT_AVAILABLE,

    /** The install/update has not been (fully) downloaded yet.  */
    ERROR_DOWNLOAD_NOT_PRESENT,

    /** The install is already in progress.  */
    ERROR_INSTALL_IN_PROGRESS,

    /**
     * The download/install is not allowed, due to the current device state (e.g.&nbsp;low battery, low
     * disk space, ...).
     */
    ERROR_INSTALL_NOT_ALLOWED,

    /** The install is unavailable to this user or device.  */
    ERROR_INSTALL_UNAVAILABLE,

    /** An internal error happened in the Bazaar.  */
    ERROR_INTERNAL_ERROR,

    /** The request that was sent by the app is malformed.  */
    ERROR_INVALID_REQUEST,

    /** Bazaar app is either not installed or not the official version.  */
    ERROR_BAZAAR_NOT_FOUND,

    /** An unknown error occurred.  */
    ERROR_UNKNOWN,

    /** No error occurred.  */
    NO_ERROR
}