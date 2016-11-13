package be.vrt.ui.adapter.delegate.text.paragraph

import android.view.ViewGroup
import android.widget.TextView
import be.vrt.ui.adapter.delegate.DefaultHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.paragraph.ParagraphViewHolder
import be.vrt.ui.model.type.HTMLTag

class ParagraphDelegate : DefaultHTMLElementAdapterDelegate<TextView, TextualViewStyle, TextualLayout, ParagraphViewHolder>() {

    override val viewType: Int = -1

    override fun isForViewType(tag: HTMLTag, position: Int): Boolean = tag == HTMLTag.P

    override fun onCreateViewHolder(parent: ViewGroup): ParagraphViewHolder
            = ParagraphViewHolder(TextualLayout(parent.context, TextualViewStyle.body2Style))
}