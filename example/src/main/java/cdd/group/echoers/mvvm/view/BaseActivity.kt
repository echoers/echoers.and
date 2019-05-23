package cdd.group.echoers.mvvm.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.echoers.library.mvvm.view.AbsCompactActivity
import com.echoers.library.mvvm.viewmodel.AbsViewModelFactory

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
open abstract class BaseActivity: AbsCompactActivity() {

    protected fun <T: ViewModel> bindViewModel(clazz: Class<T>) : T {
        return ViewModelProviders.of(this, AbsViewModelFactory(this)).get(clazz)
    }

}