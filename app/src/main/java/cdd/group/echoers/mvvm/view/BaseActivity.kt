package cdd.group.echoers.mvvm.view

import cdd.group.echoers.api.Api
import cdd.group.echoers.api.END_POINT
import com.echoers.library.http.ApiFactory
import com.echoers.library.mvvm.view.AbsCompactActivity

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package cdd.group.echoers.mvvm.view
 * @date    2019/4/2 11:05 PM
 * @author  Raphael Zhang
 * @discription
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
abstract class BaseActivity: AbsCompactActivity() {

    val repository by lazy {
        ApiFactory.instance(this).createApi(Api::class.java, END_POINT)
    }
}