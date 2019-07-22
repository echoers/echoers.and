package com.echoers.library.log

/**
 * Created by raphael
 * @project echoers.and
 * @package com.echoers.library.logger
 * @date    2019-07-21 21:16
 * @author  raphael
 * @discription // 系统日志
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 * @modified by raphael
 **/
interface Logger {
    /**
     * 日志是否启动
     */
    fun debug(): Boolean

    /**
     * debug日志
     */
    fun d(tag: String, log: String? = null)

    /**
     * 系统信息日志
     */
    fun i(tag: String, log: String? = null)

    /**
     * 系统警告日志
     */
    fun w(tag: String, log: String? = null)

    /**
     * 系统错误日志
     */
    fun e(tag: String, log: String? = null)
}