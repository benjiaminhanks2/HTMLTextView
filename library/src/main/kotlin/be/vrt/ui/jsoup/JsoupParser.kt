package be.vrt.ui.jsoup

import be.vrt.ui.command.Command
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class JsoupParser(html: String) {

    private val document: Document

    init {
        document = Jsoup.parse(html)
    }

    fun getCommands(): List<Command?> {
        val bodyElements: Elements = document.selectAllHTMLElements()
        val commands: List<Command?> = bodyElements
                .map { it.toCommand() }
                .filterNotNull()

        return commands
    }
}