package com.jean.moviesarchitectcoders.core.data.network.interceptor

import com.jean.moviesarchitectcoders.BuildConfig
import com.jean.moviesarchitectcoders.core.data.network.NetworkConstants.API_KEY_NAME
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(API_KEY_NAME, BuildConfig.TMDB_API_KEY)
            .build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }

}