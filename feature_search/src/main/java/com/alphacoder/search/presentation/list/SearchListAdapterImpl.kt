package com.alphacoder.search.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alphacoder.core.view.EmptyViewHolder
import javax.inject.Inject

class SearchListAdapterImpl @Inject constructor(
    private val callback: Callback
) : SearchListAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_EMPTY){
            EmptyViewHolder.create(parent)
        }else {
            SearchItemViewHolder.create(parent, callback)
        }
    }

    override fun getItemCount() = listItems.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is SearchItemViewHolder-> holder.bind(listItems[position])
            is EmptyViewHolder -> holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == listItems.size) {
            VIEW_TYPE_EMPTY
        } else {
            VIEW_TYPE_JOB
        }
    }
}