package be.vrt.ui.jsoup

import be.vrt.ui.command.Command
import be.vrt.ui.command.ImageCommand
import be.vrt.ui.command.LinkCommand
import be.vrt.ui.command.TextCommand
import be.vrt.ui.constant.HTMLAttributes
import be.vrt.ui.constant.HTMLElement
import be.vrt.ui.type.DefaultHTMLElementType
import org.jsoup.helper.StringUtil
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

internal fun Document.selectAllHTMLElements(): Elements = this.body().select(HTMLElement.allElementSelector)

internal fun Element.toHTMLElementType(): DefaultHTMLElementType? = try {
    DefaultHTMLElementType.valueOf(this.tagName().toUpperCase())
} catch (e: IllegalArgumentException) {
    null
}

fun Element.toCommand(): Command? {
    var command: Command? = null
    val htmlElementType: DefaultHTMLElementType? = this.toHTMLElementType()

    //Let users implement the adapter delegates pattern!
    //https://github.com/sockeqwe/AdapterDelegates

    //User should add his own delegates to the Builder-object
    //loop and check if the found tag in the HTML should be rendered natively.

    //default for when no viewType was associated with the tag? WebView?

    //for now:
    //Here is some sample scraping output to proof a POC
    when (htmlElementType) {
        DefaultHTMLElementType.P,
        DefaultHTMLElementType.B,
        DefaultHTMLElementType.I,
        DefaultHTMLElementType.H1,
        DefaultHTMLElementType.H2,
        DefaultHTMLElementType.H3,
        DefaultHTMLElementType.H4,
        DefaultHTMLElementType.H5,
        DefaultHTMLElementType.H6 -> command = processTextCommand(text())
        DefaultHTMLElementType.IMG -> command = processImageCommand(getSrc(), getAlt())
        DefaultHTMLElementType.A -> command = processLinkCommand(text(), getHref())
        else -> { }
    }
    return command
}

private fun processLinkCommand(text: String, attr: String): Command? {
    val textCommand: Command? = processTextCommand(text)
    return if (textCommand != null && !StringUtil.isBlank(attr))
        LinkCommand(textCommand, attr)
    else
        null
}

private fun processImageCommand(url: String, alt: String): Command? = if (!StringUtil.isBlank(url) && !StringUtil.isBlank(alt)) ImageCommand(url, alt) else null

private fun processTextCommand(text: String): Command? = if (!StringUtil.isBlank(text)) TextCommand(text) else null

internal fun Element.getSrc(): String = attr(HTMLAttributes.src)

internal fun Element.getAlt(): String = attr(HTMLAttributes.alt)

internal fun Element.getHref(): String = attr(HTMLAttributes.href)