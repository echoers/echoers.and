package com.echoers.library.utils


/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.utils
 * @date    2019-06-24 23:04
 * @author  Raphael Zhang
 * @discription 通用单例类
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
open class SingletonHolder<out T, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}