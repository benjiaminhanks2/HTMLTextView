package be.vrt.ui.jsoup

import be.vrt.ui.constant.HTMLAttributes
import be.vrt.ui.constant.HTMLElements
import be.vrt.ui.model.type.HTMLTag
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

internal fun Document.selectAllHTMLElements(): Elements = this.body().select(HTMLElements.allElementSelector)

val org.jsoup.nodes.Element.htmlTag: HTMLTag?
    get() = try {
        HTMLTag.valueOf(this.tagName().toUpperCase())
    } catch (e: IllegalArgumentException) {
        null
    }

val org.jsoup.nodes.Element.cssClass: MutableSet<String>?
    get() = this.classNames()

val org.jsoup.nodes.Element.src: String
    get() = attr(HTMLAttributes.src)

val org.jsoup.nodes.Element.alt: String
    get() = attr(HTMLAttributes.alt)

val org.jsoup.nodes.Element.href: String
    get() = attr(HTMLAttributes.href)