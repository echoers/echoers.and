package com.echoers.library.utils

import android.text.TextUtils
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by Raphael Zhang
 * @project echoers.and
 * @package com.echoers.library.utils
 * @date    2019-05-27 19:38
 * @author  Raphael Zhang
 * @discription 加密解密工具类
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/

fun MD5(string: String): String {
    if (TextUtils.isEmpty(string)) {
        return ""
    }
    var md5: MessageDigest
    try {
        md5 = MessageDigest.getInstance("MD5")
        val bytes = md5.digest(string.toByteArray())
        var result = ""
        for (b in bytes) {
            var temp = Integer.toHexString(b.toInt() and 0xff)
            if (temp.length == 1) {
                temp = "0$temp"
            }
            result += temp
        }
        return result
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

    return ""
}