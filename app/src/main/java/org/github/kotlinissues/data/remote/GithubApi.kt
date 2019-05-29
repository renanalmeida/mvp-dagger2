package org.github.kotlinissues.data.remote

import io.reactivex.Observable
import org.github.kotlinissues.model.Issue
import retrofit2.http.GET

interface GithubApi {

    @GET("JetBrains/kotlin/issues")
    fun getIssues() : Observable<List<Issue>>


}