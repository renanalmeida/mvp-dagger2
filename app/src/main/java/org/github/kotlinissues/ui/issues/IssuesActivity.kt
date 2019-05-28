package org.github.kotlinissues.ui.issues

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.github.kotlinissues.R
import org.github.kotlinissues.data.DataRepository
import org.github.kotlinissues.data.remote.GithubApi
import org.github.kotlinissues.databinding.ActivityIssueBinding
import org.github.kotlinissues.model.Issue

class IssuesActivity: AppCompatActivity(), IssuesContract.View{


    private lateinit var binding: ActivityIssueBinding
    private val issuesAdapter = IssuesAdapter()
    private val presenter:IssuesPresenter by lazy {  IssuesPresenter(this,  DataRepository(GithubApi.create()))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_issue)
        binding.adapter = issuesAdapter
        presenter.subscribe()
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

    override fun getContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}