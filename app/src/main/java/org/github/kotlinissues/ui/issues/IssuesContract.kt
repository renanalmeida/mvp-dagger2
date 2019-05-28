package org.github.kotlinissues.ui.issues

import org.github.kotlinissues.model.Issue
import org.github.kotlinissues.ui.base.BasePresenter
import org.github.kotlinissues.ui.base.BaseView

interface IssuesContract {

    interface View : BaseView {

        fun setLoadingIndicator(active: Boolean)

        fun showIssues(issues: List<Issue>)

        fun showError(active: Boolean)
    }

    interface Presenter : BasePresenter<View> {

        fun loadIssues()

    }
}