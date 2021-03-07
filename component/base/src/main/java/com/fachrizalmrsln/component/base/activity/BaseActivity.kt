@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.fachrizalmrsln.component.base.activity

import androidx.appcompat.app.AppCompatActivity
import com.fachrizalmrsln.component.base.viewmodel.Message
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import splitties.alertdialog.appcompat.alertDialog
import splitties.alertdialog.appcompat.message
import splitties.alertdialog.appcompat.okButton
import splitties.toast.longToast
import splitties.toast.toast

abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private var isAlertShow = false

    protected abstract fun setupComponent()

    fun showMessage(message: Message) {
        when (message) {
            is Message.Toast -> showMessageToast(message.message)
            is Message.LongToast -> showMessageLongToast(message.message)
            is Message.Dialog -> showMessageDialog(message.message)
        }
    }

    fun showMessageDialog(msg: String?) {
        msg?.let {
            if (!isAlertShow) {
                isAlertShow = true
                alertDialog {
                    message = it
                    setCancelable(false)
                    okButton { dialog ->
                        isAlertShow = false
                        dialog.dismiss()
                    }
                }.show()
            }
        }
    }

    fun showMessageToast(msg: String?) {
        msg?.let { toast(it) }
    }

    fun showMessageLongToast(msg: String?) {
        msg?.let { longToast(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

}