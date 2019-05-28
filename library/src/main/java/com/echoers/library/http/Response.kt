package com.echoers.library.http

import java.net.HttpURLConnection

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package cdd.group.echoers.entity
 * @date    2019/4/2 2:48 PM
 * @author  Raphael Zhang
 * @discription Http基础响应类
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
data class Response<T>(
    val code: Int,
    val message: String,
    val results: T
)

class ResponseCode {
    companion object {
        const val RESPONSE_OK = 10000
    }
}

/**
 * 定义常用的http响应码
 */
enum class HttpResponseCode(var code: Int, var message: String) {
    HTTP_BAD_REQUEST(HttpURLConnection.HTTP_BAD_REQUEST, "请检查参数是否正确"),
    HTTP_UNAUTHORIZED(HttpURLConnection.HTTP_UNAUTHORIZED, "登录失效，请重新登录"),
    HTTP_FORBIDDEN(HttpURLConnection.HTTP_FORBIDDEN, "登录失效，请重新登录"),
    HTTP_NOT_FOUND(HttpURLConnection.HTTP_NOT_FOUND, "请求数据不存在"),
    HTTP_INTERNAL_ERROR(HttpURLConnection.HTTP_INTERNAL_ERROR, "服务器内部错误"),
    HTTP_GATEWAY_TIMEOUT(HttpURLConnection.HTTP_GATEWAY_TIMEOUT, "网关超时"),
    HTTP_UNAVAILABLE(HttpURLConnection.HTTP_UNAVAILABLE, "服务不可用")
}