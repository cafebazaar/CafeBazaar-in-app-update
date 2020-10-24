package com.farsitel.bazaar.inappupdate.callback

import com.farsitel.bazaar.inappupdate.install.InstallState

interface InstallStateUpdatedListener {
    fun onStateChange(installState: InstallState)
}