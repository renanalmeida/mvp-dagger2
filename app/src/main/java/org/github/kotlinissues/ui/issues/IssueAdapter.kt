package org.github.kotlinissues.ui.issues

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.github.kotlinissues.R
import org.github.kotlinissues.databinding.ItemIssueBinding
import org.github.kotlinissues.model.Issue

class IssuesAdapter() : RecyclerView.Adapter<IssuesAdapter.PostViewHolder>() {

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

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Post item
     */
    class PostViewHolder(private val binding: ItemIssueBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a post into the view
         */
        fun bind(issue: Issue) {
            binding.issue = issue
            binding.executePendingBindings()
        }
    }
}