package org.github.kotlinissues.ui.issues

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.github.kotlinissues.data.IDataRepository
import org.github.kotlinissues.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class IssuesPresenter @Inject constructor( val repository: IDataRepository): IssuesContract.Presenter{

    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    private lateinit var mView: IssuesContract.View

    override fun subscribe(view: IssuesContract.View) {
        mView = view
        loadIssues()
    }

    override fun unsubscribe() {
        mCompositeDisposable.clear()
    }

    @SuppressLint("CheckResult")
    override fun loadIssues() {
        mView.setLoadingIndicator(true)
        mView.showError(false)
        repository.getKotlinIssues().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe( {
                mView.setLoadingIndicator(false)
                mView.showIssues(it)},{
                mView.setLoadingIndicator(false)
                mView.showError(true)
            })
    }

}