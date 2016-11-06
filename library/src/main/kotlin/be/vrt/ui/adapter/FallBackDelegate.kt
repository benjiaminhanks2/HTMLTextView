package be.vrt.ui.adapter

import android.view.ViewGroup
import be.vrt.ui.adapter.viewholder.FallBackViewHolder
import be.vrt.ui.model.HTMLElement
import org.jetbrains.anko.UI
import org.jetbrains.anko.textView

class FallBackDelegate : AbsHTMLElementAdapterDelegate<FallBackViewHolder>() {

    object COMPANION {
        val id: Int = Int.MAX_VALUE - 1
    }

    override fun onBindViewHolder(item: HTMLElement, viewHolder: FallBackViewHolder, payLoads: List<Any>) = viewHolder.bind(item)

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup): FallBackViewHolder {
        val view = parent.context.UI {
            textView {
                id = COMPANION.id
            }
        }.view
        return FallBackViewHolder(view)
    }
}