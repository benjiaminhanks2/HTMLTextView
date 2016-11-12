package be.vrt.ui.utils

import android.app.Activity
import android.content.Context
import android.support.v7.widget.HTMLTextView
import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView

fun android.view.ViewManager.htmlTextView(theme: Int = 0): HTMLTextView = htmlTextView(theme) {}
inline fun ViewManager.htmlTextView(theme: Int = 0, init: HTMLTextView.() -> Unit): HTMLTextView {
    return ankoView(::HTMLTextView, theme, init)
}

fun Activity.htmlTextView(theme: Int = 0): HTMLTextView = htmlTextView(theme) {}
inline fun Activity.htmlTextView(theme: Int = 0, init: HTMLTextView.() -> Unit): HTMLTextView {
    return ankoView(::HTMLTextView, theme, init)
}

fun Context.htmlTextView(theme: Int = 0): HTMLTextView = htmlTextView(theme) {}
inline fun Context.htmlTextView(theme: Int = 0, init: HTMLTextView.() -> Unit): HTMLTextView {
    return ankoView(::HTMLTextView, theme, init)
}