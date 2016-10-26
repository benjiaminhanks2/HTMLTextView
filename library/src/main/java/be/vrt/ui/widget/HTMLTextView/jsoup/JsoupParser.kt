package be.vrt.ui.widget.HTMLTextView.jsoup

import be.vrt.ui.widget.HTMLTextView.ElementType
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class JsoupParser(html: String) {

    private val document: Document

    init {
        document = Jsoup.parse(html)
        test()
    }

    private fun test() {
        document.children().forEach {
            val elementType: ElementType = it.getElementType()
            when (elementType) {
                ElementType.A -> println("found A tag")
            }
        }
    }
}