package be.vrt.ui.adapter.layout.webview

import android.content.Context
import android.webkit.WebView
import be.vrt.ui.adapter.layout.Layout
import be.vrt.ui.adapter.layout.style.WebViewStyle
import org.jetbrains.anko.UI
import org.jetbrains.anko.webView

class WebViewLayout(context: Context,
                    webViewStyle: WebViewStyle = WebViewStyle.defaultStyle) : Layout<WebView, WebViewStyle> {
    override val view: WebView by lazy {
        context.UI {
            webView { }.setStyle(webViewStyle)
        }.view as WebView
    }
}