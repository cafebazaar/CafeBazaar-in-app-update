package com.farsitel.bazaar.inappupdate.exception

// todo fill messages
enum class InstallErrorCode(val code: Int, val message: String) {

    /** The API is not available on this device.  */
    ERROR_API_NOT_AVAILABLE(-1, "---"),

    /** The install/update has not been (fully) downloaded yet.  */
    ERROR_DOWNLOAD_NOT_PRESENT(-2, "---"),

    /** The install is already in progress.  */
    ERROR_INSTALL_IN_PROGRESS(-3, "---"),

    /**
     * The download/install is not allowed, due to the current device state (e.g.&nbsp;low battery, low
     * disk space, ...).
     */
    ERROR_INSTALL_NOT_ALLOWED(-4, "---"),

    /** The install is unavailable to this user or device.  */
    ERROR_INSTALL_UNAVAILABLE(-5, "---"),

    /** An internal error happened in the Bazaar.  */
    ERROR_INTERNAL_ERROR(-6, "---"),

    /** The request that was sent by the app is malformed.  */
    ERROR_INVALID_REQUEST(-7, "---"),

    /** Bazaar app is either not installed.  */
    ERROR_BAZAAR_NOT_FOUND(-8, "---"),

    /** Bazaar app is not the official version */
    ERROR_BAZAAR_INVALID_VERSION(-9, "feature is not available on this version of bazaar client"),

    /** An unknown error occurred.  */
    ERROR_UNKNOWN(-10, "---");

    companion object {
        fun errorCodeToEnum(errorCode: Int): InstallErrorCode {
            for (i in values().indices) {
                if (values()[i].code == errorCode) {
                    return values()[i]
                }
            }
            return ERROR_UNKNOWN
        }
    }
}