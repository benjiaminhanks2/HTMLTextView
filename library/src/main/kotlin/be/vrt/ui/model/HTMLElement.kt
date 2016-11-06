package be.vrt.ui.model

import be.vrt.ui.jsoup.*
import be.vrt.ui.type.HTMLTag

class HTMLElement(element: org.jsoup.nodes.Element) {

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