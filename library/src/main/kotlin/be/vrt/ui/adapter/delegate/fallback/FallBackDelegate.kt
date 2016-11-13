package be.vrt.ui.adapter.delegate.fallback
import android.view.ViewGroup
import android.widget.TextView
import be.vrt.ui.adapter.delegate.DefaultHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import be.vrt.ui.adapter.layout.style.TextualViewStyle.Companion.fallBackTextStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.fallback.FallBackViewHolder
import be.vrt.ui.model.type.HTMLTag

//TODO Fallback to show HTML in a WebView
class FallBackDelegate : DefaultHTMLElementAdapterDelegate<TextView, TextualViewStyle, TextualLayout, FallBackViewHolder>() {
    override val viewType: Int = Integer.MAX_VALUE - 1

    override fun isForViewType(tag: HTMLTag, position: Int): Boolean  = true

    override fun onCreateViewHolder(parent: ViewGroup): FallBackViewHolder {
        val itemView = TextualLayout(parent.context, fallBackTextStyle)
        return FallBackViewHolder(itemView)
    }
}