package be.vrt.ui.jsoup

import be.vrt.ui.model.HTMLElement
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.*

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
                    .map { it.toElement() }
                    .filterUnknownTagElements()

            return HTMLElements
        }
}

private fun Iterable<HTMLElement>.filterUnknownTagElements(): List<HTMLElement> {
    val destination = ArrayList<HTMLElement>()
    for (element in this) if (element.htmlTag != null) destination.add(element)
    return destination
}