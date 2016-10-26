package be.vrt.ui.widget.HTMLTextView

import android.content.Context
import be.vrt.ui.widget.HTMLTextView.jsoup.JsoupParser
import org.jetbrains.anko._LinearLayout

class HTMLTextView(context: Context, htmlString : String) : _LinearLayout(context) {
    init {
        val jsoupParser = JsoupParser(htmlString)
    }
}