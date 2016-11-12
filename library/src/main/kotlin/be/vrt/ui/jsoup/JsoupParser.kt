package be.vrt.ui.jsoup

import be.vrt.ui.model.HTMLElement
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class JsoupParser(html: String) {

    private val document: Document

    init {
        document = Jsoup.parse(html)
        htmlElements
    }

    val htmlElements: List<HTMLElement>
        get() {
            val bodyElements: Elements = document.selectAllHTMLElements()
            val HTMLElements: List<HTMLElement> = bodyElements
                    .map(::HTMLElement)
                    .filter(unknownTagPredicate)

            return HTMLElements
        }
}

val unknownTagPredicate: (HTMLElement) -> Boolean = { it.htmlTag != null }