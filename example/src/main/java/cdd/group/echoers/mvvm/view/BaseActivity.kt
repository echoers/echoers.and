package cdd.group.echoers.mvvm.view

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
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
abstract class BaseActivity: AbsCompactActivity() {

    protected fun <VM: ViewModel> bindViewModel(clazz: Class<VM>) : VM {
        return ViewModelProviders.of(this, AbsViewModelFactory(this)).get(clazz)
    }

    protected fun <DB: ViewDataBinding> bindDataBinding(): DB {
        return DataBindingUtil.setContentView(this, contentViewLayoutId()) as DB
    }

}