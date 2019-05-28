package org.github.kotlinissues.data

import io.reactivex.Observable
import org.github.kotlinissues.model.Issue

interface IDataRepository {
    fun getKotlinIssues(): Observable<List<Issue>>
}