package be.vrt.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import be.vrt.ui.model.HTMLElement

class HTMLDelegationAdapter(val delegatesManager: AdapterDelegatesManager<AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>> = AdapterDelegatesManager()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items : List<HTMLElement> = emptyList()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = delegatesManager.onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = delegatesManager.onBindViewHolder(items, position, holder)

    override fun getItemViewType(position: Int): Int = delegatesManager.getItemViewType(items, position)

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) = delegatesManager.onViewRecycled(holder)

    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean = delegatesManager.onFailedToRecycleView(holder)

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) = delegatesManager.onViewAttachedToWindow(holder)

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) = delegatesManager.onViewDetachedFromWindow(holder)
}