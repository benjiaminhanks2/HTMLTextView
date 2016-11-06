package be.vrt.ui.model

import be.vrt.ui.jsoup.*
import be.vrt.ui.model.type.HTMLTag
import org.jsoup.nodes.Element

class HTMLElement(element: Element) {

    val htmlTag : HTMLTag?
    val cssClass : MutableSet<String>?
    val id : String
    val text : String
    val src : String
    val alt : String
    val href : String

    init {
        htmlTag = element.htmlTag
        cssClass = element.cssClass
        id = element.id()
        text = element.text()
        src = element.src
        alt = element.alt
        href = element.href
    }
}