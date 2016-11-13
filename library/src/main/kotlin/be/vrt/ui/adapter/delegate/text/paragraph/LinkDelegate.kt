package be.vrt.ui.adapter.delegate.text.paragraph

import android.view.ViewGroup
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.TextualViewStyle.Companion.linkStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.paragraph.LinkViewHolder
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag

class LinkDelegate : AbsHTMLElementAdapterDelegate<LinkViewHolder>() {
    override val viewType: Int
        get() = 64363

    override fun onBindViewHolder(item: HTMLElement, viewHolder: LinkViewHolder, payLoads: List<Any>) =
            viewHolder.bind(item)

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
        var isForViewType = false
        if (item.htmlTag != null) {
            isForViewType = item.htmlTag == HTMLTag.A
        }
        return isForViewType
    }

    override fun onCreateViewHolder(parent: ViewGroup): LinkViewHolder = LinkViewHolder(TextualLayout(parent.context, linkStyle))
}