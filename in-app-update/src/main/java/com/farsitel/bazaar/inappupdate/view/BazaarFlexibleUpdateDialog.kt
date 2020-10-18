package com.farsitel.bazaar.inappupdate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.farsitel.bazaar.inappupdate.R


class BazaarFlexibleUpdateDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_cafe_flexible_update, container, false)
    }
}