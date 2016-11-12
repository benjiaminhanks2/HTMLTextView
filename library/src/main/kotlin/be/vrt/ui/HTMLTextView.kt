package be.vrt.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import be.vrt.ui.adapter.DelegationAdapter
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.jsoup.JsoupParser
import be.vrt.ui.model.HTMLElement
import org.jetbrains.anko.recyclerview.v7._RecyclerView

class HTMLTextView(context: Context) : _RecyclerView(context) {

    var htmlDelegationAdapter: DelegationAdapter = DelegationAdapter()

    init {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setHasFixedSize(true)
        setWillNotDraw(true)
        adapter = htmlDelegationAdapter
    }

    fun setHTMLString(htmlString: String) {
        val htmlElements: List<HTMLElement> = JsoupParser(htmlString).htmlElements
        htmlDelegationAdapter.items = htmlElements
    }

    fun setAdapterDelegates(delegates: List<AbsHTMLElementAdapterDelegate<ViewHolder>>) {
        delegates.forEach {
            htmlDelegationAdapter.delegatesManager.addDelegate(it.viewType, it)
        }
        htmlDelegationAdapter.notifyDataSetChanged()
    }

    fun addAdapterDelegate(delegate: AbsHTMLElementAdapterDelegate<ViewHolder>) {
        htmlDelegationAdapter.delegatesManager.addDelegate(delegate.viewType, delegate)
        htmlDelegationAdapter.notifyDataSetChanged()
    }
}