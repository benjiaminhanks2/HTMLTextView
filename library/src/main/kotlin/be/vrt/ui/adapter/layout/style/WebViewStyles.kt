package be.vrt.ui.adapter.layout.style

import android.webkit.WebView

interface WebViewStyle : ViewStyle<WebView> {
    companion object {
        val defaultStyle: WebViewStyle = object : WebViewStyle {
            override fun invoke(webView: WebView) {
                with(webView) {}
            }
        }
    }
}