@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.fachrizalmrsln.component.base.util

import androidx.recyclerview.widget.RecyclerView

class RecyclerViewPaging(
    private val block: (Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private var lastPosition = 0

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState != RecyclerView.SCROLL_STATE_IDLE) return

        recyclerView.layoutManager?.let { layoutManager ->
            val lastItem = layoutManager.findViewByPosition(layoutManager.itemCount.minus(1))
            lastItem?.let { view ->
                val lastItemAdapterPosition = layoutManager.getPosition(view)
                lastItemAdapterPosition
                    .takeIf {
                        layoutManager.isViewPartiallyVisible(
                            view,
                            true,
                            false
                        ) && it != lastPosition
                    }
                    ?.let {
                        lastPosition = it
                        block.invoke(it)
                    }
            }
        }

    }

}