package com.echoers.library.http

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