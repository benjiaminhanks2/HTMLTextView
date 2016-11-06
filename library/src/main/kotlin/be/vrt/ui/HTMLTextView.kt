package be.vrt.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import be.vrt.ui.adapter.HTMLDelegationAdapter
import be.vrt.ui.jsoup.JsoupParser
import org.jetbrains.anko.recyclerview.v7._RecyclerView

//todo: Make a nice builder for me to work with.
class HTMLTextView(context: Context, htmlString: String) : _RecyclerView(context) {
    init {
        val htmlElements: List<be.vrt.ui.model.HTMLElement> = JsoupParser(htmlString).htmlElements

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setHasFixedSize(true)
        setWillNotDraw(true)

        adapter = HTMLDelegationAdapter(htmlElements)
    }
}