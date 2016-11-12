package be.vrt.ui.adapter.layout.text

import android.content.Context
import android.widget.TextView
import be.vrt.ui.adapter.layout.Layout
import be.vrt.ui.adapter.layout.style.TextualViewStyle
import org.jetbrains.anko.UI
import org.jetbrains.anko.textView

class TextualLayout(val context: Context, val textualStyle: TextualViewStyle = TextualViewStyle.defaultStyle) : Layout<TextView, TextualViewStyle> {
    override val view: TextView by lazy {
        context.UI {
            textView {

            }.setStyle(textualStyle)
        }.view as TextView
    }
}