package com.echoers.library

import androidx.multidex.MultiDexApplication
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

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

        /**
         * 初始化Logger，debug环境开启日志打印
         */
        Logger.addLogAdapter(object: AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

}