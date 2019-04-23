package com.echoers.library.components

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.echoers.library.R
import kotlinx.android.synthetic.main.lib_dialog_laoding.*

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package com.echoers.library.components
 * @date    2019/4/2 10:57 PM
 * @author  Raphael Zhang
 * @discription 加载框
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
class LoadingDialog(context: Context, var message: String = "加载中..."): AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lib_dialog_laoding)

        tvMessage.text = message
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }
}