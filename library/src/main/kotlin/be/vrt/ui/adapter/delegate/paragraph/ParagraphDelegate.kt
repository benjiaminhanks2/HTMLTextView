package be.vrt.ui.adapter.delegate.paragraph

import android.view.ViewGroup
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.paragraph.ParagraphViewHolder
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag

class ParagraphDelegate : AbsHTMLElementAdapterDelegate<ParagraphViewHolder>() {
    override val viewType: Int
        get() = 34356

    override fun onBindViewHolder(item: HTMLElement, viewHolder: ParagraphViewHolder, payLoads: List<Any>) {
        viewHolder.bind(item)
    }

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
        var isForViewType = false
        if (item.htmlTag != null) {
            isForViewType = item.htmlTag == HTMLTag.P
        }
        return isForViewType
    }

    override fun onCreateViewHolder(parent: ViewGroup): ParagraphViewHolder = ParagraphViewHolder(TextualLayout(parent.context, TextualViewStyle.PStyle))
}