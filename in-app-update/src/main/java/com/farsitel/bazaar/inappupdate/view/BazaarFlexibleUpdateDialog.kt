package com.farsitel.bazaar.inappupdate.view

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.farsitel.bazaar.inappupdate.R
import kotlinx.android.synthetic.main.dialog_bazaar_flexible_update.*


class BazaarFlexibleUpdateDialog : DialogFragment() {

    private var callback: Callback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.callback = context as? Callback
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_bazaar_flexible_update, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isCancelable = false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        updateDescriptionMain.text = getString(
            R.string.flexible_update_description_main,
            arguments?.getString(APP_NAME) ?: ""
        )
        update.setOnClickListener {
            callback?.onUpdate()
        }
        reject.setOnClickListener {
            callback?.onCancel()
        }
    }

    override fun onDetach() {
        callback = null
        super.onDetach()
    }

    companion object {
        const val TAG = "bazaarFlexibleUpdateDialogTag"
        private const val APP_NAME = "appName"

        fun getInstance(appName: String) = BazaarFlexibleUpdateDialog().apply {
            arguments = Bundle().apply {
                putString(APP_NAME, appName)
            }
        }
    }

    interface Callback {
        fun onUpdate()
        fun onCancel()
    }
}