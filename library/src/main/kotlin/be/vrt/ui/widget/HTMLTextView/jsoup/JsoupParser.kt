package be.vrt.ui.widget.HTMLTextView.jsoup

import android.util.Log
import be.vrt.ui.widget.HTMLTextView.ElementType
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class JsoupParser(html: String) {

    private val document: Document

    init {
        document = Jsoup.parse(html)
        test(document.body().select("*"))
    }

    private fun test(children: Elements) {
        children.forEach {
            val elementType: ElementType? = it.getElementType()
            when (elementType) {
                ElementType.A -> printExampleLogMessage(it, elementType)
                ElementType.P -> printExampleLogMessage(it, elementType)
                ElementType.IMG -> printExampleLogMessage(it, elementType)
                ElementType.B -> printExampleLogMessage(it, elementType)
                ElementType.I -> printExampleLogMessage(it, elementType)
                ElementType.H1 -> printExampleLogMessage(it, elementType)
                ElementType.H2 -> printExampleLogMessage(it, elementType)
                ElementType.H3 -> printExampleLogMessage(it, elementType)
                ElementType.H4 -> printExampleLogMessage(it, elementType)
                ElementType.H5 -> printExampleLogMessage(it, elementType)
                ElementType.H6 -> printExampleLogMessage(it, elementType)
                else -> {}
            }
        }
    }

    private fun printExampleLogMessage(elementType: Element, type: ElementType) {
        when (type) {
            ElementType.A -> Log.d(this.javaClass.simpleName, type.name + ": ${elementType.text()}: URL: ${elementType.absUrl("href")}")
            ElementType.IMG -> Log.d(this.javaClass.simpleName, type.name + ": ${elementType.text()} URL: ${elementType.attr("src")}")
            else -> Log.d(this.javaClass.simpleName, type.name + ": ${elementType.text()}")
        }
    }
}