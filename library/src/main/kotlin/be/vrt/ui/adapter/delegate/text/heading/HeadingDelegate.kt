package be.vrt.ui.adapter.delegate.text.heading

import android.view.ViewGroup
import android.widget.TextView
import be.vrt.ui.adapter.delegate.DefaultHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.heading.HeadingViewHolder
import be.vrt.ui.model.type.HTMLTag

class HeadingDelegate : DefaultHTMLElementAdapterDelegate<TextView, TextualViewStyle, TextualLayout, HeadingViewHolder>() {

    override val viewType: Int = -1

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

    override fun isForViewType(tag: HTMLTag, position: Int): Boolean {
        this.tag = tag
        return tag == HTMLTag.H1 || tag == HTMLTag.H2 || tag == HTMLTag.H3 || tag == HTMLTag.H4 || tag == HTMLTag.H5 || tag == HTMLTag.H6
    }

    override fun onCreateViewHolder(parent: ViewGroup): HeadingViewHolder = HeadingViewHolder(TextualLayout(parent.context, style()))
}