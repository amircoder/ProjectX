package com.alphacoder.search.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.feature_search.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_job.view.*

class SearchItemViewHolder(
    override val containerView: View,
    private val callback: SearchListAdapter.Callback
) : LayoutContainer, RecyclerView.ViewHolder(containerView) {

    companion object {
        fun create(
            parent: ViewGroup,
            callback: SearchListAdapter.Callback
        ) = SearchItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_job, parent, false
                ), callback
        )
    }

    fun bind(jobItem: JobItem){
        setupClickListeners(jobItem)
        setupView(jobItem)
    }

    private fun setupView(jobItem: JobItem) {
        with(itemView){
            jobTitle.text = jobItem.title
        }
    }

    private fun setupClickListeners(jobItem: JobItem) {
        itemView.setOnClickListener {
            callback.onJobItemClicked(jobItem)
        }
    }

}
