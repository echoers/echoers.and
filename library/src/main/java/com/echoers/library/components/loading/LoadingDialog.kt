package com.echoers.library.components.loading

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.echoers.library.R
import org.jetbrains.anko.find
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.components.loading
 * @date    2019-04-23 18:43
 * @author  Raphael Zhang
 * @discription 基于FragmentDialog的加载框
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
class LoadingDialog(var message: String = "加载中..."): DialogFragment(), LoadingDialogComponent {

    private lateinit var tvMessage: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lib_dialog_laoding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMessage = view.find(R.id.tvMessage)
        tvMessage.text = message
    }

    override fun onStart() {
        super.onStart()
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.let {
            val params = it.attributes
            params.width = it.windowManager.defaultDisplay.width
            it.attributes = params
        }
    }

    override fun startLoading(context: Context) {
        if (context is AppCompatActivity) {
            dialog?.let {
                if (!it.isShowing) {
                    show(context.supportFragmentManager, null)
                }
            }
        } else {
            context.toast("当前Activity实例必须是AppCompatActivity或者其子类")
        }
    }

    override fun stopLoading() {
        dialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }

    override fun setLoadingMessage(message: String) {
        context?.let {
            with(it) {
                runOnUiThread {
                    tvMessage.text = message
                }
            }
        }
    }
}