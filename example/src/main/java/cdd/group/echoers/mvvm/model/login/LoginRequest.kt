package cdd.group.echoers.mvvm.model.login

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package cdd.group.echoers.mvvm.model.login
 * @date    2019-05-26 20:56
 * @author  Raphael Zhang
 * @discription
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
data class LoginRequest (
    var loginName: String = "",
    var password: String = ""
)