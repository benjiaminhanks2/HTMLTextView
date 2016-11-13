package be.vrt.ui.adapter.viewholder.fallback

import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.AbsTextualViewHolder
import be.vrt.ui.model.HTMLElement

class FallBackViewHolder(textualView: TextualLayout) : AbsTextualViewHolder(textualView) {
    override fun bind(item: HTMLElement) {
        if (item.htmlTag != null) {
            if (item.cssClass?.size ?: 0 >= 1) {
                textView.text = "${item.htmlTag} ${item.cssClass}"
            } else {
                textView.text = "${item.htmlTag}"
            }
        }
    }
}