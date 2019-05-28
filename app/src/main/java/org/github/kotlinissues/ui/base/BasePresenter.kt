package org.github.kotlinissues.ui.base

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    init {
        inject()
    }

    abstract fun start()

    private fun inject() {

    }
}