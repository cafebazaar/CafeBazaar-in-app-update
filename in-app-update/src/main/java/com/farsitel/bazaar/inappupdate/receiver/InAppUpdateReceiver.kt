package com.farsitel.bazaar.inappupdate.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.farsitel.bazaar.inappupdate.connection.ReceiverCallback

internal class InAppUpdateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            observer?.onDataReceived(intent)
        }
    }

    companion object {
        private var observer: ReceiverCallback? = null

        fun setObserver(observer: ReceiverCallback) {
            this.observer = observer
        }
    }
}