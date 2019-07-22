package com.echoers.library.log

import com.echoers.library.BuildConfig

/**
 * Created by raphael
 * @project echoers.and
 * @package com.echoers.library.logger
 * @date    2019-07-21 21:20
 * @author  raphael
 * @discription //
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 * @modified by raphael
 **/
class PrettyLogger: Logger {

    var isDebug = BuildConfig.DEBUG

    override fun debug(): Boolean {
        return isDebug
    }

    override fun d(tag: String, log: String?) {
        if (debug()) com.orhanobut.logger.Logger.d(tag, log)
    }

    override fun i(tag: String, log: String?) {
        if (debug()) com.orhanobut.logger.Logger.i(tag, log)
    }

    override fun w(tag: String, log: String?) {
        if (debug()) com.orhanobut.logger.Logger.w(tag, log)
    }

    override fun e(tag: String, log: String?) {
        if (debug()) com.orhanobut.logger.Logger.e(tag, log)
    }
}