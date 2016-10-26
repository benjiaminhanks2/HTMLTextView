package be.vrt.ui.widget.HTMLTextView.jsoup

import be.vrt.ui.widget.HTMLTextView.ElementType
import org.jsoup.nodes.Element

fun <T : Element> T.getElementType(): ElementType {
    return ElementType.valueOf(this.tagName())
}