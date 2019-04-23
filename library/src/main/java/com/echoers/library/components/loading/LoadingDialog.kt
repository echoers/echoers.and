package com.echoers.library.components.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.echoers.library.R
import org.jetbrains.anko.find

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.components.loading
 * @date    2019-04-23 18:43
 * @author  Raphael Zhang
 * @discription 基于FragmentDialog的加载框
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
class LoadingDialog(var message: String = "加载中..."): DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lib_dialog_laoding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.find<TextView>(R.id.tvMessage).text = message
    }

    override fun onStart() {
        super.onStart()
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.let {
            val params = it.attributes
            params.width = it.windowManager.defaultDisplay.width
            it.attributes = params
        }
    }
}