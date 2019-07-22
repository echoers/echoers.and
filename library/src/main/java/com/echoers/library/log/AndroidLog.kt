package com.echoers.library.log

import android.util.Log
import com.echoers.library.BuildConfig

/**
 * Created by raphael
 * @project echoers.and
 * @package com.echoers.library.log
 * @date    2019-07-22 21:17
 * @author  raphael
 * @discription // android系统自带log
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 * @modified by raphael
 **/
class AndroidLog: Logger {

    var isDebug = BuildConfig.DEBUG

    override fun debug(): Boolean {
        return isDebug
    }

    override fun d(tag: String, log: String?) {
        if (debug()) Log.d(tag, log)
    }

    override fun i(tag: String, log: String?) {
        if (debug()) Log.i(tag, log)
    }

    override fun w(tag: String, log: String?) {
        if (debug()) Log.w(tag, log)
    }

    override fun e(tag: String, log: String?) {
        if (debug()) Log.e(tag, log)
    }
}