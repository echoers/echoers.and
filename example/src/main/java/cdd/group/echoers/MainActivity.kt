package cdd.group.echoers

import cdd.group.echoers.mvvm.view.BaseActivity
import cdd.group.echoers.mvvm.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val loginViewModel by lazy {
        bindViewModel(LoginViewModel::class.java)
    }

    override fun contentViewLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {
        btnLogin.setOnClickListener {
            loginViewModel.login()
        }
    }
}
