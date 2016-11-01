package be.vrt.ui.widget.HTMLTextView

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.ViewManager
import be.vrt.ui.widget.HTMLTextView.command.Command
import be.vrt.ui.widget.HTMLTextView.jsoup.JsoupParser
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.recyclerview.v7._RecyclerView

class HTMLTextView(context: Context, htmlString: String) : _RecyclerView(context) {
    init {
        val jsoupParser = JsoupParser(htmlString)
        val commandList: List<Command?> = jsoupParser.getCommands()

        commandList.forEach {
            Log.d(this.javaClass.simpleName, it.toString())
        }
    }
}

//<editor-fold desc="Anko Extensions for adding the view to the root">
inline fun ViewManager.htmlTextView(htmlString: String, theme: Int = 0): HTMLTextView = htmlTextView(htmlString, theme) {}

inline fun ViewManager.htmlTextView(htmlString: String, theme: Int = 0, init: _RecyclerView.() -> Unit): HTMLTextView {
    return ankoView({ HTMLTextView(it, htmlString) }, theme, init)
}

inline fun Activity.htmlTextView(htmlString: String, theme: Int = 0): HTMLTextView = htmlTextView(htmlString, theme) {}
inline fun Activity.htmlTextView(htmlString: String, theme: Int = 0, init: _RecyclerView.() -> Unit): HTMLTextView {
    return ankoView({ HTMLTextView(it, htmlString) }, theme, init)
}

inline fun Context.htmlTextView(htmlString: String, theme: Int = 0): HTMLTextView = htmlTextView(htmlString, theme) {}
inline fun Context.htmlTextView(htmlString: String, theme: Int = 0, init: _RecyclerView.() -> Unit): HTMLTextView {
    return ankoView({ HTMLTextView(it, htmlString) }, theme, init)
}
//</editor-fold>