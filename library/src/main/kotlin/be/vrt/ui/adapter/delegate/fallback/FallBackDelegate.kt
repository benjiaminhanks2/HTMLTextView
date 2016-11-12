package be.vrt.ui.adapter.delegate.fallback

import android.view.ViewGroup
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.fallback.FallBackViewHolder
import be.vrt.ui.model.HTMLElement

class FallBackDelegate : AbsHTMLElementAdapterDelegate<FallBackViewHolder>() {

    override val viewType: Int = Integer.MAX_VALUE - 1

    override fun onBindViewHolder(item: HTMLElement, viewHolder: FallBackViewHolder, payLoads: List<Any>) = viewHolder.bind(item)

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup): FallBackViewHolder {
        val itemView = TextualLayout(parent.context)
        return FallBackViewHolder(itemView)
    }
}