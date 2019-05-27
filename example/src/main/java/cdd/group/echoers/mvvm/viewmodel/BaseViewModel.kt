package cdd.group.echoers.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import cdd.group.echoers.api.Repository
import com.echoers.library.mvvm.viewmodel.AbsViewModel
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.net.ConnectException
import java.net.HttpURLConnection

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package cdd.group.echoers.mvvm.viewmodel
 * @date    2019-05-26 12:01
 * @author  Raphael Zhang
 * @discription TODO
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
open class BaseViewModel(private val context: Context): AbsViewModel(context) {

    val repository by lazy {
        Repository(context)
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
                    HttpURLConnection.HTTP_FORBIDDEN -> {
                        toast("获取授权失败")
                    }

                    else -> {
                        toast("http请求出现问题")
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