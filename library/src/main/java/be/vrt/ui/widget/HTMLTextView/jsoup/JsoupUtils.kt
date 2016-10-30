package be.vrt.ui.widget.HTMLTextView.jsoup

import be.vrt.ui.widget.HTMLTextView.ElementType
import org.jsoup.nodes.Element

fun <T : Element> T.getElementType(): ElementType? {
    var elementType: ElementType? = null

    try {
        elementType = ElementType.valueOf(this.tagName().toUpperCase())
    } catch (e : IllegalArgumentException) {
    } finally {
        if (elementType != null) {
            if (!elementType.shouldBeRenderedNative)
                elementType = null
        }
    }

    return elementType
}