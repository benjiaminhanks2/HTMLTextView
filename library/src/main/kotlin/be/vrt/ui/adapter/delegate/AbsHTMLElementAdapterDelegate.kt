package be.vrt.ui.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import be.vrt.ui.model.HTMLElement

open abstract class AbsHTMLElementAdapterDelegate<VH : RecyclerView.ViewHolder> {

    abstract val viewType: Int

    open fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean = false

    abstract fun onBindViewHolder(item: HTMLElement, viewHolder: VH, payLoads: List<Any>)

    abstract fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean

    abstract fun onCreateViewHolder(parent: ViewGroup): VH

    open fun onViewRecycled(holder: RecyclerView.ViewHolder) {
    }

    open fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
    }

    open fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
    }
}