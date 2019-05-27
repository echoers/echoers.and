package cdd.group.echoers.api

import android.content.Context
import cdd.group.echoers.entity.LoginResponse
import com.echoers.library.http.Response
import com.echoers.library.http.ApiFactory
import com.echoers.library.http.BaseRepository
import com.echoers.library.http.END_POINT

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package cdd.group.echoers.api
 * @date    2019-05-28 00:46
 * @author  Raphael Zhang
 * @discription 统一接口请求数据源
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/

class Repository(context: Context): BaseRepository() {

    private val repository by lazy {
        ApiFactory.instance(context).createApi(Api::class.java, END_POINT)
    }

    suspend fun loginAsync(loginName: String, password: String): Response<LoginResponse> {
        return apiCall { repository.loginAsync(loginName, password).await() }
    }
}