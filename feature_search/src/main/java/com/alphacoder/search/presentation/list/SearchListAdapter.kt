package com.alphacoder.search.presentation.list

import androidx.recyclerview.widget.RecyclerView
import com.alphacoder.core.domain.model.JobItem

abstract class SearchListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val VIEW_TYPE_JOB = 1
        const val VIEW_TYPE_EMPTY = 2
    }

    var listItems: List<JobItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface Callback {
        fun onJobItemClicked(jobItem: JobItem)
    }
}