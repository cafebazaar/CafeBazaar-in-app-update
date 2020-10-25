package com.farsitel.bazaar.inappupdate.connection

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.farsitel.bazaar.inappupdate.BAZAAR_PACKAGE_NAME
import com.farsitel.bazaar.inappupdate.receiver.InAppUpdateReceiver

internal class ReceiverConnection(private val context: Context) {

    private var callback: BazaarConnectionCallback? = null

    private var broadcastCallback = object : ReceiverCallback {
        override fun onDataReceived(intent: Intent) {
            onDataReceivedFromBazaar(intent)
        }
    }

    fun getAppUpdateInfo() {
        listenToBroadcastReceiver()
        val intent = createBroadcastIntent(GET_UPDATE_INFO_ACTION)
        context.sendBroadcast(intent)
    }

    private fun listenToBroadcastReceiver() {
        InAppUpdateReceiver.setObserver(broadcastCallback)
    }

    private fun onDataReceivedFromBazaar(intent: Intent) {
        if (intent.extras == null) {
            return
        }
        when (intent.action) {
            GET_UPDATE_INFO_RESPONSE_ACTION -> {
                onGetUpdateInfoRespond(intent.extras!!)
            }
        }
    }

    private fun onGetUpdateInfoRespond(extras: Bundle) {
        if (ReceiverDataHandler.isSuccessful(extras)) {
            val updateVersionCode = ReceiverDataHandler.getVersionCodeFromInfo(extras)
            callback?.onGetUpdateInfo(updateVersionCode)
        } else {
            callback?.onGetUpdateInfoFailure(ReceiverDataHandler.getFailureCode(extras))
        }
    }

    private fun createBroadcastIntent(action: String) = Intent().apply {
        setPackage(BAZAAR_PACKAGE_NAME)
        setAction(action)
        putExtra(PACKAGE_NAME_KEY, context.packageName)
    }

    fun setCallback(callback: BazaarConnectionCallback) {
        this.callback = callback
    }

    companion object {
        const val PACKAGE_NAME_KEY = "packageName"
        private const val GET_UPDATE_INFO_ACTION = "$BAZAAR_PACKAGE_NAME.updateInfo"
        private const val GET_UPDATE_INFO_RESPONSE_ACTION = "$BAZAAR_PACKAGE_NAME.updateInfoRes"

        @Volatile
        private var instance: ReceiverConnection? = null
        private val lockObject = Any()

        fun getInstance(context: Context): ReceiverConnection {
            if (instance == null) {
                synchronized(lockObject) {
                    if (instance == null) {
                        instance = ReceiverConnection(context)
                    }
                }
            }
            return instance!!
        }
    }
}