package com.echoers.library.http

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.http
 * @date    2019-05-28 01:07
 * @author  Raphael Zhang
 * @discription 通用数据源处理
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
open class BaseRepository {
    /**
     * 处理Http响应函数
     */
    protected suspend fun <T: Any> apiCall(call: suspend () -> Response<T>): Response<T> {
        return call.invoke()
    }
}