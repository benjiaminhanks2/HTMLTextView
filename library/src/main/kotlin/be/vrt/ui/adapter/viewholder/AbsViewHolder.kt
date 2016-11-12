package be.vrt.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import be.vrt.ui.adapter.layout.Layout
import be.vrt.ui.adapter.layout.style.ViewStyle
import be.vrt.ui.model.HTMLElement

abstract class AbsViewHolder<T : View, in S : ViewStyle<T>, V : Layout<T, S>>(layout: V)
    : RecyclerView.ViewHolder(layout.view) {

    abstract fun bind(item: HTMLElement)
}