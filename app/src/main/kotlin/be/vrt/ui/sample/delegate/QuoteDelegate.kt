package be.vrt.ui.sample.delegate

import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag
import be.vrt.ui.sample.viewholder.QuoteViewHolder
import org.jetbrains.anko.UI
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView

class QuoteDelegate : AbsHTMLElementAdapterDelegate<QuoteViewHolder>() {
    override val viewType: Int = 1
    override fun onBindViewHolder(item: HTMLElement, viewHolder: QuoteViewHolder, payLoads: List<Any>) = viewHolder.bind(item)

    companion object {
        val textViewId = 42
    }

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
        var isForViewType = false
        if (item.htmlTag != null && item.cssClass != null) {
            val cssClass = item.cssClass
            if (cssClass?.size ?: 0 >= 0) {
                val isQuote = cssClass?.any { it == "quote" } == true
                isForViewType = item.htmlTag == HTMLTag.P && isQuote
            }
        }
        return isForViewType
    }

    override fun onCreateViewHolder(parent: ViewGroup): QuoteViewHolder {
        val itemView = parent.context.UI {
            textView {
                id = textViewId
                typeface = Typeface.MONOSPACE
                setTypeface(typeface, Typeface.ITALIC)
                setLineSpacing(1F, 1.6F)
                textSize = 18f
                padding = dip(8)
                gravity = Gravity.CENTER_HORIZONTAL
            }
        }.view
        return QuoteViewHolder(itemView)
    }
}