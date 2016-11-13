package be.vrt.ui.sample.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.sample.delegate.QuoteDelegate

class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: HTMLElement) {
        val textView = itemView.findViewById(QuoteDelegate.textViewId) as TextView
        textView.text = "Quote: ${item.text}"
    }
}