package com.echoers.library.log.logger

import com.echoers.library.log.AndroidLog
import com.echoers.library.log.Logger
import com.echoers.library.log.PrettyLogger

/**
 * Created by raphael
 * @project echoers.and
 * @package com.echoers.library.log.logger
 * @date    2019-07-22 21:13
 * @author  raphael
 * @discription // 生成日志对象
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 * @modified by raphael
 **/
class LoggerFactory {

    companion object {

        const val PRETTYLOGGER = 0

        fun create(loggerType: Int): Logger {
            return when(loggerType) {
                PRETTYLOGGER -> PrettyLogger()
                else -> AndroidLog()
            }
        }
    }
}