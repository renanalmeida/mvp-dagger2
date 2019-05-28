package org.github.kotlinissues.data

import io.reactivex.Observable
import org.github.kotlinissues.data.remote.GithubApi
import org.github.kotlinissues.model.Issue

class DataRepository(val api: GithubApi) : IDataRepository {

    override fun getKotlinIssues(): Observable<List<Issue>> {
        return api.getIssues()
    }
}