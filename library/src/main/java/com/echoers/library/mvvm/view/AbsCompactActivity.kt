package com.echoers.library.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package com.echoers.library.mvvm.view
 * @date    2019/4/2 11:17 PM
 * @author  Raphael Zhang
 * @discription Activity抽象基类
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
abstract class AbsCompactActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initData()
        initListener()
    }

    // 初始化布局id
    protected abstract fun contentViewLayoutId(): Int

    // 初始化View
    protected abstract fun initView()

    // 初始化数据
    protected abstract fun initData()

    // 初始化数据监听
    protected abstract fun initListener()
}