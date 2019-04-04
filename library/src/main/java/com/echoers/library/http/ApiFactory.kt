package com.echoers.library.http

import android.content.Context
import com.echoers.library.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.orhanobut.logger.Logger
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
 * @discription TODO
 * @org     cdd.group
 * @email   raphael_zhang@echoers.cn
 **/
class ApiFactory private constructor(var context: Context) {

    private val okHttpClient by lazy {
        OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .cache(Cache(context.cacheDir, 50 * 1024 * 1024))
            .addInterceptor(ChuckInterceptor(context))
            .build()
    }

    fun <T> createApi(clazz: Class<T>, endPoint: String? = null): T {
        if (endPoint == null) throw IllegalArgumentException("endPoint should not be null")
        if (BuildConfig.DEBUG) {
            val loggerInterceptor = HttpLoggingInterceptor {
                Logger.d(it)
            }
            loggerInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient.newBuilder()
                .addNetworkInterceptor(loggerInterceptor)
        }
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(endPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(clazz)
    }

    companion object {
        @Volatile private var instance: ApiFactory? = null
        fun instance(context: Context): ApiFactory =
                instance ?: synchronized(ApiFactory::class.java) {
                    instance ?: ApiFactory(context).also {
                        instance = it
                    }
                }
    }
}