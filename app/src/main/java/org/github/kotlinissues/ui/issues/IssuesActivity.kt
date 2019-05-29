package org.github.kotlinissues.ui.issues

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import org.github.kotlinissues.R
import org.github.kotlinissues.databinding.ActivityIssueBinding
import org.github.kotlinissues.model.Issue
import javax.inject.Inject

class IssuesActivity: DaggerAppCompatActivity(), IssuesContract.View{

    private lateinit var binding: ActivityIssueBinding
    private val issuesAdapter = IssuesAdapter()

    @Inject
    lateinit var presenter:IssuesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_issue)
        binding.adapter = issuesAdapter
        presenter.subscribe(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun setLoadingIndicator(active: Boolean) {
        binding.progressVisibility = if(active) View.VISIBLE else View.GONE
    }

    override fun showIssues(issues: List<Issue>) {
        issuesAdapter.updateIssues(issues)
    }

    override fun showError(active: Boolean) {
        binding.showError = if(active) View.VISIBLE else View.GONE
    }

}