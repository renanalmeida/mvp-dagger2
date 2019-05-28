package org.github.kotlinissues.ui.issues

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setupIssuesRecyclerView")
fun setupIssuesRecyclerView(view: RecyclerView, adapter: IssuesAdapter?) {
    val layoutManager = LinearLayoutManager(view.context)
    view.layoutManager = layoutManager
    view.addItemDecoration( DividerItemDecoration(view.context, LinearLayoutManager.VERTICAL))
    adapter?.let {
        view.adapter = adapter
    }
}