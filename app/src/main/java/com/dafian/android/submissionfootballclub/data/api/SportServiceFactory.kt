package com.dafian.android.submissionfootballclub.data.api

import android.content.Context
import com.dafian.android.submissionfootballclub.BuildConfig
import com.dafian.android.submissionfootballclub.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SportServiceFactory {

    fun create(context: Context): SportService {
        val client = makeClientService(makeLoggingInterceptor(), makeCache(context))
        return makeCountryService(context, client, makeGson())
    }

    private fun makeCountryService(context: Context, client: OkHttpClient, gson: Gson): SportService {
        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(SportService::class.java)
    }

    private fun makeClientService(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor { chain ->
                val ongoing = chain.request().newBuilder()
                ongoing.addHeader("Content-Type", "application/json")
                chain.proceed(ongoing.build())
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
    }

    private fun makeGson(): Gson {
        return GsonBuilder()
            .create()
    }

    private fun makeCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }
}