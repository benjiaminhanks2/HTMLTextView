package be.vrt.ui.adapter.viewholder.text

import android.widget.TextView
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.AbsViewHolder
import be.vrt.ui.model.HTMLElement

abstract class AbsTextualViewHolder(textualLayout: TextualLayout) : AbsViewHolder<TextView, TextualViewStyle, TextualLayout>(textualLayout) {

    var textView: TextView

    init {
        this.textView = textualLayout.view
    }

    override fun bind(item: HTMLElement) {
        textView.text = item.text
    }
}