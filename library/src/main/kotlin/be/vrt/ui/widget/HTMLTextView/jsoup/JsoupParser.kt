package be.vrt.ui.widget.HTMLTextView.jsoup

import be.vrt.ui.widget.HTMLTextView.command.Command
import be.vrt.ui.widget.HTMLTextView.command.ImageCommand
import be.vrt.ui.widget.HTMLTextView.command.LinkCommand
import be.vrt.ui.widget.HTMLTextView.command.TextCommand
import be.vrt.ui.widget.HTMLTextView.type.DefaultHTMLElementType
import org.jsoup.Jsoup
import org.jsoup.helper.StringUtil
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class JsoupParser(html: String) {

    private val document: Document

    init {
        document = Jsoup.parse(html)
    }

    fun getCommands(): List<Command?> {
        val bodyElements: Elements = document.body().select("*")
        val commands: List<Command?> = bodyElements
                .map { it.toCommand() }
                .filterNotNull()

        return commands
    }
}

fun Element.toCommand(): Command? {
    var command: Command? = null
    val htmlElementType: DefaultHTMLElementType? = this.toHTMLElementType()
    when (htmlElementType) {
        DefaultHTMLElementType.P,
        DefaultHTMLElementType.B,
        DefaultHTMLElementType.I,
        DefaultHTMLElementType.H1,
        DefaultHTMLElementType.H2,
        DefaultHTMLElementType.H3,
        DefaultHTMLElementType.H4,
        DefaultHTMLElementType.H5,
        DefaultHTMLElementType.H6 -> command = processTextCommand(this.text())
        DefaultHTMLElementType.IMG -> command = processImageCommand(this.attr("src"), this.attr("alt"))
        DefaultHTMLElementType.A -> command = processLinkCommand(this.text(), this.attr("href"))
        else -> {}
    }
    return command
}

fun processLinkCommand(text: String, attr: String): Command? {
    val textCommand: Command? = processTextCommand(text)
    return if (textCommand != null && !StringUtil.isBlank(attr))
        LinkCommand(textCommand, attr)
    else
        null
}

fun processImageCommand(url: String, alt : String): Command? = if (!StringUtil.isBlank(url) && !StringUtil.isBlank(alt)) ImageCommand(url, alt) else null

fun processTextCommand(text: String): Command? = if (!StringUtil.isBlank(text)) TextCommand(text) else null

private fun Element.toHTMLElementType(): DefaultHTMLElementType? {
    val tagName = this.tagName().toUpperCase()
    var htmlElementType: DefaultHTMLElementType? = null

    try {
        htmlElementType = DefaultHTMLElementType.valueOf(tagName)
    } catch (e: IllegalArgumentException) {
    }

    return htmlElementType
}