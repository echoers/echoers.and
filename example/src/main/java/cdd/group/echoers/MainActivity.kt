package cdd.group.echoers

import androidx.lifecycle.Observer
import cdd.group.echoers.databinding.ActivityMainBinding
import cdd.group.echoers.mvvm.viewmodel.LoginViewModel
import com.echoers.library.mvvm.view.BaseCompactActivity
import com.echoers.library.utils.MD5
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseCompactActivity<LoginViewModel, ActivityMainBinding>() {

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
                login(mViewDataBinding.etLoginName.text.toString(), MD5(mViewDataBinding.etPassword.text.toString()))
            }
        }
    }
}
