package be.vrt.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import be.vrt.ui.adapter.FallBackDelegate
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag

class FallBackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textView: TextView

    init {
        textView = itemView.findViewById(FallBackDelegate.COMPANION.textview_id) as TextView
    }

    fun bind(item: HTMLElement) {
        when (item.htmlTag) {
            HTMLTag.A,
            HTMLTag.P,
            HTMLTag.IMG,
            HTMLTag.B,
            HTMLTag.I,
            HTMLTag.H1,
            HTMLTag.H2,
            HTMLTag.H3,
            HTMLTag.H4,
            HTMLTag.H5,
            HTMLTag.H6 -> textView.text = "${item.htmlTag} ${item.cssClass} :: \r\n${item.text} \n"
            else -> {
            }
        }
    }
}