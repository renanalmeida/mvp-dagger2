package org.github.kotlinissues.di.issues

import dagger.Binds
import dagger.Module
import org.github.kotlinissues.di.ActivityScope
import org.github.kotlinissues.ui.issues.IssuesContract
import org.github.kotlinissues.ui.issues.IssuesPresenter

@Module
abstract class IssuesModule {

    @ActivityScope
    @Binds
    internal abstract fun issuesPresenter(presenter: IssuesPresenter): IssuesContract.Presenter

}