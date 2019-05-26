package com.echoers.library.mvvm.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.echoers.library.mvvm.viewmodel.AbsViewModelFactory
import java.lang.reflect.ParameterizedType

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.mvvm.view
 * @date    2019-05-26 20:32
 * @author  Raphael Zhang
 * @discription 通用基础Activity
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
abstract class BaseCompactActivity<VM: ViewModel, DB: ViewDataBinding>: AbsCompactActivity() {

    protected var mViewModel: VM? = null

    protected lateinit var mViewDataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        mViewDataBinding = DataBindingUtil.setContentView(this, contentViewLayoutId())
        mViewModel = obtainViewModel()

        super.onCreate(savedInstanceState)
    }

    /**
     * 构造ViewModel
     */
    private fun obtainViewModel() : VM? {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val modelClass = type.actualTypeArguments[0] as Class<VM>
            return ViewModelProviders.of(this, AbsViewModelFactory(this)).get(modelClass)
        }
        return null
    }

}