package cdd.group.echoers.entity

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
    val result: T
)