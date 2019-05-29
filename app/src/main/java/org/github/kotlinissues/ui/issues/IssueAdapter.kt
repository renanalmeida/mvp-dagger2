package org.github.kotlinissues.ui.issues

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.github.kotlinissues.R
import org.github.kotlinissues.databinding.ItemIssueBinding
import org.github.kotlinissues.model.Issue
import org.github.kotlinissues.ui.isssuedetails.IssueDetailsActivity

class IssuesAdapter : RecyclerView.Adapter<IssuesAdapter.PostViewHolder>() {

    private var issues:List<Issue> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ItemIssueBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_issue, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return issues.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(issues[position])
    }

    fun updateIssues(issues: List<Issue>) {
        this.issues = issues
        notifyDataSetChanged()
    }


    class PostViewHolder(private val binding: ItemIssueBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(issue: Issue) {
            binding.issue = issue
            binding.root.setOnClickListener {
                val intent = Intent(it.context, IssueDetailsActivity::class.java)
                intent.putExtra("issue", issue)
                it.context.startActivity(intent)
            }
            binding.executePendingBindings()
        }
    }
}