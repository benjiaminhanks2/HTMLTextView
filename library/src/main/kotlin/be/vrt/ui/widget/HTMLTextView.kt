package be.vrt.ui.widget

import android.app.Activity
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewManager
import be.vrt.ui.adapter.HTMLDelegationAdapter
import be.vrt.ui.jsoup.JsoupParser
import be.vrt.ui.model.HTMLElement
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.recyclerview.v7._RecyclerView

class HTMLTextView(context: Context, htmlString: String) : _RecyclerView(context) {
    init {
        val htmlElements: List<HTMLElement> = JsoupParser(htmlString).htmlElements

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setHasFixedSize(true)
        setWillNotDraw(true)

        adapter = HTMLDelegationAdapter(htmlElements)
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