package com.jean.moviesarchitectcoders.di

import com.jean.moviesarchitectcoders.core.data.network.NetworkConstants.BASE_URL
import com.jean.moviesarchitectcoders.core.data.network.interceptor.ApiKeyInterceptor
import com.jean.moviesarchitectcoders.movies.data.network.MoviesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiKeyInterceptor(): ApiKeyInterceptor = ApiKeyInterceptor()

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        apiKeyInterceptor: ApiKeyInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): MoviesApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MoviesApiService::class.java)
    }

    // ----- COROUTINE INSTANCE ----- //

    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

}