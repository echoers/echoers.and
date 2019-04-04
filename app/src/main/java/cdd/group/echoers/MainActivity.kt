package cdd.group.echoers

import cdd.group.echoers.mvvm.view.BaseActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import org.jetbrains.anko.alert
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
        textView.setOnClickListener {
            val dialog = alert("加载中...", "").build()
            dialog.show()
            GlobalScope.launch {
                val login = async(IO) {
                    repository.login("", "")
                }.await()
                withContext(Main) {
                    dialog.dismiss()
                    val result = login.await()
                    if (result.code == 10000) {
                        Logger.json(result.toString())
                    } else {
                        toast(result.message)
                    }
                }
            }

        }
    }
}
