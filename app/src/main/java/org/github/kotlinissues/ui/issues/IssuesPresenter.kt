package org.github.kotlinissues.ui.issues

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.github.kotlinissues.data.IDataRepository

class IssuesPresenter(val  view: IssuesContract.View, private val repository: IDataRepository): IssuesContract.Presenter {

    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun subscribe() {
        loadIssues()
    }

    override fun unsubscribe() {
        mCompositeDisposable.clear()
    }

    @SuppressLint("CheckResult")
    override fun loadIssues() {
        view.setLoadingIndicator(true)
        view.showError(false)
        repository.getKotlinIssues().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe( {
                view.setLoadingIndicator(false)
                view.showIssues(it)},{
                view.setLoadingIndicator(false)
                view.showError(true)
            })
    }

}