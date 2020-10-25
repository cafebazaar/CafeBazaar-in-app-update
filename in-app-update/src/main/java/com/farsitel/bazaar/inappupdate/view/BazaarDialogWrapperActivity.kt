package com.farsitel.bazaar.inappupdate.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.farsitel.bazaar.inappupdate.connection.ReceiverConnection
import com.farsitel.bazaar.inappupdate.model.UpdateType
import com.farsitel.bazaar.inappupdate.util.getAppName
import com.farsitel.bazaar.inappupdate.util.isAbleToLaunch

internal class BazaarDialogWrapperActivity : AppCompatActivity(),
    BazaarFlexibleUpdateDialog.Callback {

    private var bazaarFlexibleUpdateDialog: BazaarFlexibleUpdateDialog? = null
    private var connection: ReceiverConnection = ReceiverConnection.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        disableTransition()
        super.onCreate(savedInstanceState)
        initDialog()
        showUpdateDialog()
    }

    private fun initDialog() {
        bazaarFlexibleUpdateDialog = BazaarFlexibleUpdateDialog.getInstance(
            intent.getStringExtra(APP_NAME) ?: ""
        )
    }

    private fun showUpdateDialog() {
        if (!isFinishing) {
            bazaarFlexibleUpdateDialog?.show(supportFragmentManager, BazaarFlexibleUpdateDialog.TAG)
        }
    }

    override fun onUpdate() {
        connection.onUserUpdateSelected()
        setResult(RESULT_OK)
        disableTransition()
        finish()
    }

    override fun onCancel() {
        if (bazaarFlexibleUpdateDialog?.isVisible == true) {
            bazaarFlexibleUpdateDialog?.dismissAllowingStateLoss()
        }
        connection.onDialogCancelSelected()
        setResult(RESULT_CANCELED)
        disableTransition()
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        disableTransition()
    }

    override fun onDestroy() {
        bazaarFlexibleUpdateDialog == null
        super.onDestroy()
    }

    private fun disableTransition() {
        overridePendingTransition(0, 0)
    }

    companion object {

        private const val UPDATE_TYPE = "updateType"
        private const val APP_NAME = "appName"

        fun getDialogWrapperActivityIntent(
            context: Context,
            updateType: UpdateType
        ): Intent? {
            return Intent(context, BazaarDialogWrapperActivity::class.java).apply {
                putExtra(UPDATE_TYPE, updateType.ordinal)
                putExtra(APP_NAME, getAppName(context))
            }.takeIf { it.isAbleToLaunch(context) }
        }
    }
}