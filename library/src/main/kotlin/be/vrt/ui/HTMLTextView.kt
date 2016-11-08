package be.vrt.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import be.vrt.ui.adapter.AbsHTMLElementAdapterDelegate
import be.vrt.ui.adapter.HTMLDelegationAdapter
import be.vrt.ui.jsoup.JsoupParser
import be.vrt.ui.model.HTMLElement
import org.jetbrains.anko.recyclerview.v7._RecyclerView

class HTMLTextView(context: Context) : _RecyclerView(context) {

    var htmlDelegationAdapter: HTMLDelegationAdapter = HTMLDelegationAdapter()

    init {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setHasFixedSize(true)
        setWillNotDraw(true)
    }

    fun setHTMLString(htmlString: String) {
        val htmlElements: List<HTMLElement> = JsoupParser(htmlString).htmlElements
        htmlDelegationAdapter.items = htmlElements
    }

    fun setAdapterDelegates(delegates: List<AbsHTMLElementAdapterDelegate<ViewHolder>>) {
        delegates.forEach {
            htmlDelegationAdapter.delegatesManager.addDelegate(it.viewType, it)
        }
    }

    fun addAdapterDelegate(delegate : AbsHTMLElementAdapterDelegate<ViewHolder>) {
        htmlDelegationAdapter.delegatesManager.addDelegate(delegate.viewType, delegate)
    }
}