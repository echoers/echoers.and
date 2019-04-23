package cdd.group.echoers

import cdd.group.echoers.mvvm.view.BaseActivity
import com.echoers.library.components.loading.LoadingDialog
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast

class MainActivity : BaseActivity() {

    override fun contentViewLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {
        btnLogin.setOnClickListener {
            val dialog = LoadingDialog()
            dialog.show(supportFragmentManager, null)
            GlobalScope.launch {
                val login = withContext(IO) {
                    repository.loginAsync(etLoginName.text.toString(), etPassword.text.toString())
                }
                withContext(Main) {
                    dialog.dismiss()
                    val result = login.await()
                    if (result.code == 10000) {
                        Logger.json(result.toString())
                        tvContent.text = result.toString()
                    } else {
                        toast(result.message)
                        tvContent.text = result.toString()
                    }
                }
            }

        }
    }
}
