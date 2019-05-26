package cdd.group.echoers

import androidx.lifecycle.Observer
import cdd.group.echoers.mvvm.view.BaseActivity
import cdd.group.echoers.mvvm.viewmodel.LoginViewModel
import com.echoers.library.mvvm.view.BaseCompactActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseCompactActivity<LoginViewModel, cdd.group.echoers.databinding.ActivityMainBinding>() {

//    private val loginViewModel by lazy {
//        bindViewModel(LoginViewModel::class.java)
//    }

    override fun contentViewLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mViewModel?.run {
            getLoginResponse().observe(this@MainActivity, Observer {
                toast(it.token)
            })
        }
    }

    override fun initData() {

    }

    override fun initListener() {
        btnLogin.setOnClickListener {
            mViewModel?.run {
                login()
            }
        }
    }
}
