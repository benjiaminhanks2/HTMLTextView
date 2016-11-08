package be.vrt.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import be.vrt.ui.model.HTMLElement

abstract class AbsHTMLElementAdapterDelegate<VH : RecyclerView.ViewHolder> {

    abstract val viewType: Int

    internal fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean = false

    internal abstract fun onBindViewHolder(item: HTMLElement, viewHolder: VH, payLoads: List<Any>)

    internal abstract fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean

    internal abstract fun onCreateViewHolder(parent: ViewGroup): VH

    internal fun onViewRecycled(holder: RecyclerView.ViewHolder) {
    }

    internal fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
    }

    internal fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
    }
}