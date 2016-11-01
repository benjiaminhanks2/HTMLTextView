package be.vrt.ui.jsoup

import android.content.Context
import be.vrt.ui.R
import be.vrt.ui.command.Command
import be.vrt.ui.command.ImageCommand
import be.vrt.ui.command.LinkCommand
import be.vrt.ui.command.TextCommand
import be.vrt.ui.type.DefaultHTMLElementType
import org.jsoup.Jsoup
import org.jsoup.helper.StringUtil
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class JsoupParser(ctx : Context, html: String) {

    private val document: Document
    private val cssSelectorAllElements : String
    private val cssSelectorAtrAlt : String
    private val cssSelectorAtrSrc : String
    private val cssSelectorAtrHref : String

    init {
        document = Jsoup.parse(html)
        cssSelectorAllElements = ctx.getString(R.string.cssSelector_all_elements)
        cssSelectorAtrAlt  = ctx.getString(R.string.cssSelector_attr_alt)
        cssSelectorAtrSrc  = ctx.getString(R.string.cssSelector_attr_src)
        cssSelectorAtrHref = ctx.getString(R.string.cssSelector_attr_href)
    }

    fun getCommands(): List<Command?> {
        val bodyElements: Elements = document.body().select(cssSelectorAllElements)
        val commands: List<Command?> = bodyElements
                .map { it.toCommand(cssSelectorAtrSrc ,cssSelectorAtrAlt, cssSelectorAtrHref) }
                .filterNotNull()

        return commands
    }
}

fun Element.toCommand(srcSelector : String, altSelector : String, hrefSelector : String): Command? {
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
        DefaultHTMLElementType.IMG -> command = processImageCommand(this.attr(srcSelector), this.attr(altSelector))
        DefaultHTMLElementType.A -> command = processLinkCommand(this.text(), this.attr(hrefSelector))
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