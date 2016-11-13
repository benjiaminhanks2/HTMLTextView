package be.vrt.ui.adapter.delegate

import android.view.View
import be.vrt.ui.adapter.layout.Layout
import be.vrt.ui.adapter.layout.style.ViewStyle
import be.vrt.ui.adapter.viewholder.AbsViewHolder
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag

abstract class DefaultHTMLElementAdapterDelegate<T : View, in S : ViewStyle<T>, V : Layout<T, S>, VH : AbsViewHolder<T, S, V>> : AbsHTMLElementAdapterDelegate<VH>() {
    override fun onBindViewHolder(item: HTMLElement, viewHolder: VH, payLoads: List<Any>) = viewHolder.bind(item)

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
        var isForViewType = false
        if (item.htmlTag != null) {
            isForViewType = isForViewType(item.htmlTag, position)
        }
        return isForViewType
    }

    abstract fun isForViewType(tag: HTMLTag, position: Int) : Boolean
}