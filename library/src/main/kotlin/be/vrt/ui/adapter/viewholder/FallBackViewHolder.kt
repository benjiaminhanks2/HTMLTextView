package be.vrt.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import be.vrt.ui.adapter.FallBackDelegate
import be.vrt.ui.model.HTMLElement

class FallBackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textView : TextView

    init {
        textView = itemView.findViewById(FallBackDelegate.COMPANION.id) as TextView
    }

    fun bind(item: HTMLElement) {
        textView.text = item.text
    }
}