package cdd.group.echoers.api

import cdd.group.echoers.entity.LoginResponse
import cdd.group.echoers.entity.Response
import kotlinx.coroutines.Deferred
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package cdd.group.echoers.api
 * @date    2019/4/2 2:24 PM
 * @author  Raphael Zhang
 * @discription TODO
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
interface Api {

    @POST("auth/login")
    @Headers("service_name: authservice")
    fun login(@Query("loginName") loginName: String,
              @Query("password") password: String): Deferred<Response<LoginResponse>>
}