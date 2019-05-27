package cdd.group.echoers.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cdd.group.echoers.entity.LoginResponse
import com.echoers.library.http.ResponseCode

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package cdd.group.echoers.mvvm.viewmodel
 * @date    2019-05-23 22:25
 * @author  Raphael Zhang
 * @discription  登录ViewModel
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
class LoginViewModel(context: Context): BaseViewModel(context) {

    private var loginResponse = MutableLiveData<LoginResponse>()

    fun getLoginResponse(): LiveData<LoginResponse> {
        return loginResponse
    }

    fun login(loginName: String, password: String) {
        launch {
            startLoading()
            val result = repository.loginAsync(loginName, password)
            stopLoading()
            if (result.code == ResponseCode.RESPONSE_OK) {
                toast(result.results.token)
            } else {
                toast(result.message)
            }
        }
    }
}