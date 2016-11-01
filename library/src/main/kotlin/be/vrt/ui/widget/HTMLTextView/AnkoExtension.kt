package be.vrt.ui.widget.HTMLTextView

import android.app.Activity
import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.custom.ankoView

inline fun ViewManager.htmlTextView(htmlString : String, theme : Int = 0) : HTMLTextView = htmlTextView(htmlString, theme) {}
inline fun ViewManager.htmlTextView(htmlString: String, theme : Int = 0, init : _LinearLayout.() -> Unit) : HTMLTextView {
    return ankoView({ HTMLTextView(it, htmlString) }, theme, init)
}

inline fun Activity.htmlTextView(htmlString : String, theme : Int = 0) : HTMLTextView = htmlTextView(htmlString, theme) {}
inline fun Activity.htmlTextView(htmlString: String, theme : Int = 0, init : _LinearLayout.() -> Unit) : HTMLTextView {
    return ankoView({ HTMLTextView(it, htmlString) }, theme, init)
}

inline fun Context.htmlTextView(htmlString : String, theme : Int = 0) : HTMLTextView = htmlTextView(htmlString, theme) {}
inline fun Context.htmlTextView(htmlString: String, theme : Int = 0, init : _LinearLayout.() -> Unit) : HTMLTextView {
    return ankoView({ HTMLTextView(it, htmlString) }, theme, init)
}