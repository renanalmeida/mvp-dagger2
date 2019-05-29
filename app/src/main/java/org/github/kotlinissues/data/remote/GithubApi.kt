package org.github.kotlinissues.data.remote

import android.util.Log
import io.reactivex.Observable
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.github.kotlinissues.model.Issue
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GithubApi {

    @GET("JetBrains/kotlin/issues")
    fun getIssues() : Observable<List<Issue>>


}