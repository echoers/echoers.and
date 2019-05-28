package cdd.group.echoers.mvvm.viewmodel

import android.content.Context
import cdd.group.echoers.api.Repository
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
        Repository(context)
    }

}