package cdd.group.echoers.mvvm.viewmodel

import android.content.Context
import cdd.group.echoers.api.Api
import cdd.group.echoers.api.END_POINT
import com.echoers.library.http.ApiFactory
import com.echoers.library.mvvm.viewmodel.AbsViewModel

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
        ApiFactory.instance(context).createApi(Api::class.java, END_POINT)
    }
}