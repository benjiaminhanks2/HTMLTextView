package be.vrt.ui.adapter.viewholder.fallback

import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.AbsTextualViewHolder
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag

class FallBackViewHolder(textualView: TextualLayout) : AbsTextualViewHolder(textualView) {
    override fun bind(item: HTMLElement) {
            if (item.htmlTag != null) {
                if (item.htmlTag != HTMLTag.DIV && item.htmlTag != HTMLTag.SPAN && item.htmlTag != HTMLTag.SECTION && item.htmlTag != HTMLTag.HEADER && item.htmlTag != HTMLTag.UL && item.htmlTag != HTMLTag.ARTICLE) {
                    textView.text = "Unknown tag: ${item.htmlTag} ${item.cssClass} :: \r\n${item.text} \n"
                    //Log.d(this.javaClass.simpleName, "Unknown tag: ${item.htmlTag} ${item.cssClass} :: \r\n${item.text} \n")
                }
            } else {
                textView.text = ""
            }
    }
}