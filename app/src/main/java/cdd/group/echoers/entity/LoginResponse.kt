package cdd.group.echoers.entity

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package cdd.group.echoers.entity
 * @date    2019/4/2 2:51 PM
 * @author  Raphael Zhang
 * @discription TODO
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
data class LoginResponse(
    val departmentId: String,
    val id: String,
    val name: String,
    val token: String,
    val userType: String
)