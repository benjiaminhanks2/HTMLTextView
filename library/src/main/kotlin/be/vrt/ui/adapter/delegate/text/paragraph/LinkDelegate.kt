package be.vrt.ui.adapter.delegate.text.paragraph

import android.view.ViewGroup
import android.widget.TextView
import be.vrt.ui.adapter.delegate.DefaultHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import be.vrt.ui.adapter.layout.style.TextualViewStyle.Companion.linkStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.paragraph.LinkViewHolder
import be.vrt.ui.model.type.HTMLTag

class LinkDelegate : DefaultHTMLElementAdapterDelegate<TextView, TextualViewStyle, TextualLayout, LinkViewHolder>() {
    override val viewType: Int = -1

    override fun isForViewType(tag: HTMLTag, position: Int): Boolean  = tag == HTMLTag.A

    override fun onCreateViewHolder(parent: ViewGroup): LinkViewHolder = LinkViewHolder(TextualLayout(parent.context, linkStyle))
}