package be.vrt.ui.adapter.delegate.fallback

import android.view.ViewGroup
import android.webkit.WebView
import be.vrt.ui.adapter.delegate.DefaultHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.style.WebViewStyle
import be.vrt.ui.adapter.layout.webview.WebViewLayout
import be.vrt.ui.adapter.viewholder.fallback.WebViewViewHolder
import be.vrt.ui.model.type.HTMLTag

class WebViewFallbackDelegate : DefaultHTMLElementAdapterDelegate<WebView, WebViewStyle, WebViewLayout, WebViewViewHolder>() {
    override val viewType: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup): WebViewViewHolder = WebViewViewHolder(WebViewLayout(parent.context))

    override fun isForViewType(tag: HTMLTag, position: Int): Boolean = tag == HTMLTag.IFRAME
}