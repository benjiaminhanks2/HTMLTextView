package be.vrt.ui.adapter.delegate.text.heading

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
                HTMLTag.H1 -> TextualViewStyle.display4Style
                HTMLTag.H2 -> TextualViewStyle.display3Style
                HTMLTag.H3 -> TextualViewStyle.display2Style
                HTMLTag.H4 -> TextualViewStyle.display1Style
                HTMLTag.H5 -> TextualViewStyle.headLineStyle
                HTMLTag.H6 -> TextualViewStyle.titleStyle
                else -> TextualViewStyle.titleStyle
            }

    override fun onBindViewHolder(item: HTMLElement, viewHolder: HeadingViewHolder, payLoads: List<Any>) {
        viewHolder.bind(item)
    }

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
        if(item.htmlTag != null) {
            tag = item.htmlTag
        }

        return tag == HTMLTag.H1 || tag == HTMLTag.H2 || tag == HTMLTag.H3 || tag == HTMLTag.H4 || tag == HTMLTag.H5 || tag == HTMLTag.H6
    }


    override fun onCreateViewHolder(parent: ViewGroup): HeadingViewHolder = HeadingViewHolder(TextualLayout(parent.context, style()))
}