package com.farsitel.bazaar.inappupdate.connection

import android.content.Intent

internal interface ReceiverCallback {
    fun onDataReceived(intent: Intent?)
}