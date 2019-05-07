package com.echoers.library.components.loading

import android.content.Context

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.components.loading
 * @date    2019-05-06 21:54
 * @author  Raphael Zhang
 * @discription 对话框抽象类
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
interface LoadingDialogComponent {

    fun startLoading(context: Context)

    fun stopLoading()

    fun setLoadingMessage(message: String)
}