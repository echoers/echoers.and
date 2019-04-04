package cdd.group.echoers.api

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package cdd.group.echoers.api
 * @date    2019/4/2 2:58 PM
 * @author  Raphael Zhang
 * @discription TODO
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
class Repository(val api: Api?) {

    fun login(loginName: String, password: String) {
        api?.login(loginName, password)
    }
}