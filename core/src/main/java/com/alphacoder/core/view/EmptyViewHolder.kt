package com.alphacoder.core.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alphacoder.core.R
import kotlinx.android.extensions.LayoutContainer

class EmptyViewHolder(
    override val containerView: View
) : LayoutContainer, RecyclerView.ViewHolder(containerView) {

    companion object {
        fun create(
            parent: ViewGroup
        ) = EmptyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_empty, parent, false
                )
        )
    }

    fun bind() {
        // do nothing
    }
}