package be.vrt.ui.widget.HTMLTextView.jsoup

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class JsoupParser(html : String) {

    private val document: Document

    init {
        document = Jsoup.parse(html)
        val children: Elements? = document.children()
    }
}