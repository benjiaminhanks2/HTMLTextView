package be.vrt.ui.adapter.viewholder.text.paragraph

import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.AbsTextualViewHolder
import be.vrt.ui.model.HTMLElement

class LinkViewHolder(textualLayout: TextualLayout) : AbsTextualViewHolder(textualLayout) {
    override fun bind(item: HTMLElement) {
        super.bind(item)
        this.itemView.tag = item
    }
}