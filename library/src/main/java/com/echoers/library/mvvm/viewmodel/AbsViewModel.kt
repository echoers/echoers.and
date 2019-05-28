package com.echoers.library.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.echoers.library.components.LoadingDialog
import com.echoers.library.http.HttpResponseCode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast
import retrofit2.HttpException
import java.net.ConnectException

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
open class AbsViewModel(private val context: Context): ViewModel() {
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

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                stopLoading()
                handleException(e)
            }
        }
    }

    private fun handleException(e: Exception) {
        when(e) {
            is HttpException -> {
                when(e.code()) {
                    HttpResponseCode.HTTP_BAD_REQUEST.code -> {
                        toast(HttpResponseCode.HTTP_BAD_REQUEST.message)
                    }
                    HttpResponseCode.HTTP_UNAUTHORIZED.code,
                    HttpResponseCode.HTTP_FORBIDDEN.code -> {
                        toast(HttpResponseCode.HTTP_FORBIDDEN.message)
                    }
                    HttpResponseCode.HTTP_NOT_FOUND.code -> {
                        toast(HttpResponseCode.HTTP_NOT_FOUND.message)
                    }
                    HttpResponseCode.HTTP_INTERNAL_ERROR.code -> {
                        toast(HttpResponseCode.HTTP_INTERNAL_ERROR.message)
                    }
                    HttpResponseCode.HTTP_GATEWAY_TIMEOUT.code -> {
                        toast(HttpResponseCode.HTTP_GATEWAY_TIMEOUT.message)
                    }
                    HttpResponseCode.HTTP_UNAVAILABLE.code -> {
                        toast(HttpResponseCode.HTTP_UNAVAILABLE.message)
                    }
                    else -> {
                        toast("网络请求出错Code：${e.code()}， Msg：${e.message()}")
                    }
                }
            }
            is ConnectException -> {
                toast("连接超时，请稍后重试")
            }
            else -> {
                toast("网络连接失败，请检查网络设置")
            }
        }
    }
}