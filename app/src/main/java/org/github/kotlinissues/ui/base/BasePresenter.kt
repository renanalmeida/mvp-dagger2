package org.github.kotlinissues.ui.base

interface BasePresenter<T> {

    fun subscribe(view:T)

    fun unsubscribe()

}