package com.echoers.library.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.mvvm.viewmodel
 * @date    2019-05-24 00:08
 * @author  Raphael Zhang
 * @discription 通用ViewModel生成工厂
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
open class AbsViewModelFactory(val context: Context): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val constructor = modelClass.getConstructor(Context::class.java)
        return constructor.newInstance(context) as T
    }
}