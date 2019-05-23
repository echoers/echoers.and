package com.echoers.library.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.echoers.library.components.LoadingDialog
import org.jetbrains.anko.toast

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.mvvm.viewmodel
 * @date    2019-05-23 21:59
 * @author  Raphael Zhang
 * @discription 抽象ViewModel
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
open class AbsViewModel(val context: Context): ViewModel() {
    private var loadingDialog: LoadingDialog = LoadingDialog(context)

    protected fun startLoading() {
        if (!loadingDialog.isShowing) loadingDialog.show()
    }

    protected fun stopLoading() {
        if (loadingDialog.isShowing) loadingDialog.dismiss()
    }

    protected fun toast(msg: String) {
        context.toast(msg)
    }
}