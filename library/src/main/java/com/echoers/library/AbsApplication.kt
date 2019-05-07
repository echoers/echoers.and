package com.echoers.library

import androidx.multidex.MultiDexApplication

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library
 * @date    2019-04-22 16:02
 * @author  Raphael Zhang
 * @discription 全局Application，支持MultiDex
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
open class AbsApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
    }

}