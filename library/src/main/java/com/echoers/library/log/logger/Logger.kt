package com.echoers.library.log.logger

import com.echoers.library.log.Logger

/**
 * Created by raphael
 * @project echoers.and
 * @package com.echoers.library.log.logger
 * @date    2019-07-22 21:11
 * @author  raphael
 * @discription // 日志api
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 * @modified by raphael
 **/
object Logger {

    private var logger: Logger? = null

    init {
        logger = LoggerFactory.create(LoggerFactory.PRETTYLOGGER)
    }

    /**
     * 设置默认日志实现
     */
    fun setDefaultLogger(logger: Logger?) {
        if (logger == null) {
            this.logger = LoggerFactory.create(LoggerFactory.PRETTYLOGGER)
        } else {
            this.logger = logger
        }
    }

    fun i(tag: String, log: String? = "") {
        logger?.i(tag, log)
    }

    fun d(tag: String, log: String? = "") {
        logger?.d(tag, log)
    }

    fun w(tag: String, log: String? = "") {
        logger?.w(tag, log)
    }

    fun e(tag: String, log: String? = "") {
        logger?.e(tag, log)
    }
}