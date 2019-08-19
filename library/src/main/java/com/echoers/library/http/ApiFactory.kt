package com.echoers.library.http

import android.content.Context
import com.echoers.library.BuildConfig
import com.echoers.library.log.AndroidLog
import com.echoers.library.utils.SingletonHolder
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalArgumentException
import java.util.concurrent.TimeUnit

/**
 * Created by Raphael Zhang
 * @project cdd-test
 * @package com.echoers.library.http
 * @date    2019/4/2 1:44 PM
 * @author  Raphael Zhang
 * @discription Retrofit应用类
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
class ApiFactory private constructor(private val context: Context) {

    private val okHttpClient by lazy {
        var loggerInterceptor: HttpLoggingInterceptor? = null
        if (BuildConfig.DEBUG) {
            val log = object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    com.echoers.library.log.logger.Logger.setDefaultLogger(AndroidLog())
                    com.echoers.library.log.logger.Logger.e("OkHttp", message)
                }
            }
            loggerInterceptor = HttpLoggingInterceptor(log)
            loggerInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .cache(Cache(context.cacheDir, 50 * 1024 * 1024))
            .addInterceptor(ChuckInterceptor(context))
            .addNetworkInterceptor(loggerInterceptor!!)
            .build()
    }

    fun <T> createApi(clazz: Class<T>, endPoint: String? = null): T {
        if (endPoint.isNullOrEmpty()) throw IllegalArgumentException("endPoint should not be null or empty")
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(endPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(clazz)
    }

    companion object : SingletonHolder<ApiFactory, Context>(::ApiFactory)
}