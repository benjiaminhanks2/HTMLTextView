package be.vrt.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import be.vrt.ui.adapter.DelegationAdapter
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.jsoup.JsoupParser
import be.vrt.ui.model.HTMLElement

class HTMLTextView(context: Context) : RecyclerView(context) {

    var htmlDelegationAdapter: DelegationAdapter = DelegationAdapter()

    init {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        super.setAdapter(htmlDelegationAdapter)
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


    @Deprecated(message = "Use addAdapterDelegate", level = DeprecationLevel.HIDDEN)
    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
    }

    @Deprecated(message = "Use getHtmlAdapterDelegate", level = DeprecationLevel.HIDDEN)
    override fun getAdapter(): Adapter<*> {
        return super.getAdapter()
    }

    fun addAdapterDelegate(delegate: AbsHTMLElementAdapterDelegate<ViewHolder>) {
        htmlDelegationAdapter.delegatesManager.addDelegate(delegate.viewType, delegate)
        htmlDelegationAdapter.notifyDataSetChanged()
    }
}