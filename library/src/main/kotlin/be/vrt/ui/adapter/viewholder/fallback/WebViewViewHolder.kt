package be.vrt.ui.adapter.viewholder.fallback

import android.webkit.WebChromeClient
import android.webkit.WebView
import be.vrt.ui.adapter.layout.style.WebViewStyle
import be.vrt.ui.adapter.layout.webview.WebViewLayout
import be.vrt.ui.adapter.viewholder.AbsViewHolder
import be.vrt.ui.model.HTMLElement

class WebViewViewHolder(webViewLayout : WebViewLayout) : AbsViewHolder<WebView, WebViewStyle, WebViewLayout>(webViewLayout) {

    private var webView: WebView

    init {
        this.webView = webViewLayout.view
        with(webView) {
            settings.javaScriptEnabled = true
            setWebChromeClient(WebChromeClient())
        }
    }

    override fun bind(item: HTMLElement) {
        this.webView.loadUrl(item.src)
    }
}