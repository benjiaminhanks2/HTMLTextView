package be.vrt.ui.adapter.delegate.heading

import android.view.ViewGroup
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.heading.HeadingViewHolder
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag

class HeadingDelegate : AbsHTMLElementAdapterDelegate<HeadingViewHolder>() {
    override val viewType: Int
        get() = 3953

    var tag: HTMLTag = HTMLTag.H1
    fun style(): TextualViewStyle =
            when (tag) {
                HTMLTag.H1 -> TextualViewStyle.H1Style
                HTMLTag.H2 -> TextualViewStyle.H2Style
                HTMLTag.H3 -> TextualViewStyle.H3Style
                HTMLTag.H4 -> TextualViewStyle.H4Style
                HTMLTag.H5 -> TextualViewStyle.H5Style
                HTMLTag.H6 -> TextualViewStyle.H6Style
                else -> TextualViewStyle.H1Style
            }

    override fun onBindViewHolder(item: HTMLElement, viewHolder: HeadingViewHolder, payLoads: List<Any>) {
        viewHolder.bind(item)
    }

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean = position == 10


    override fun onCreateViewHolder(parent: ViewGroup): HeadingViewHolder = HeadingViewHolder(TextualLayout(parent.context, style()))
}