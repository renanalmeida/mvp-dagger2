package org.github.kotlinissues.ui.isssuedetails

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import org.github.kotlinissues.R
import org.github.kotlinissues.databinding.ActivityIssueDetailsBinding
import org.github.kotlinissues.model.Issue

class IssueDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIssueDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val issue = intent.getParcelableExtra<Issue>("issue")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_issue_details)
        binding.openGitHubListener = getOnOpenGitHubUrlListener(issue)
        binding.issue = issue
    }

    private fun getOnOpenGitHubUrlListener(issue: Issue) = View.OnClickListener {
        val intent =  Intent(Intent.ACTION_VIEW).setData(Uri.parse(issue.url))
        startActivity(intent)
    }
}
