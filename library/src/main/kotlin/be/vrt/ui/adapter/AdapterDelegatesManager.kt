package be.vrt.ui.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import be.vrt.ui.model.HTMLElement

abstract class AdapterDelegatesManager {

    object COMPANION {
        val FALLBACK_DELEGATE_VIEW_TYPE = Integer.MAX_VALUE - 1
    }

    internal val delegates: SparseArrayCompat<AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>> = SparseArrayCompat()
    val fallbackDelegate = FallBackDelegate()

    init {
        addDelegate(COMPANION.FALLBACK_DELEGATE_VIEW_TYPE, fallbackDelegate)
    }

    fun addDelegate(viewType: Int,
                    delegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>,
                    allowReplacingDelegate: Boolean = false): AdapterDelegatesManager {
        if (!allowReplacingDelegate && delegates.get(viewType) != null) {
            throw IllegalArgumentException(
                    "An AdapterDelegate is already registered for the viewType = "
                            + viewType
                            + ". Already registered AdapterDelegate is "
                            + delegates.get(viewType))
        }

        delegates.put(viewType, delegate)
        return this
    }

    fun removeDelegate(delegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>): AdapterDelegatesManager {
        val indexToRemove = delegates.indexOfValue(delegate)

        if (indexToRemove >= 0) {
            delegates.removeAt(indexToRemove)
        }
        return this
    }

    fun removeDelegate(viewType: Int): AdapterDelegatesManager {
        delegates.remove(viewType)
        return this
    }

    fun getItemViewType(items : List<HTMLElement>, position: Int): Int {
        val delegatesCount: Int = delegates.size()
        for (i in 0..delegatesCount) {
            val adapterDelegate = i.toAdapterDelegate()
            if (adapterDelegate?.isForViewType(items[position], items, position) ?: false)  {
                return delegates.keyAt(position)
            }
        }

        return COMPANION.FALLBACK_DELEGATE_VIEW_TYPE
    }

    fun onCreateViewHolder(parent : ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        val adapterDelegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder> = getDelegateForViewType(viewType)
        return adapterDelegate.onCreateViewHolder(parent)
    }

    fun onBindViewHolder(items : List<HTMLElement>, position: Int, viewHolder : RecyclerView.ViewHolder, payLoads : List<Any> = emptyList()) {
        val adapterDelegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder> = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onBindViewHolder(items[position], viewHolder, payLoads)
    }

    fun onViewRecycled(viewHolder : RecyclerView.ViewHolder) {
        val adapterDelegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder> = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onViewRecycled(viewHolder)
    }

    fun onFailedToRecycleView(viewHolder : RecyclerView.ViewHolder) : Boolean {
        val adapterDelegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder> = getDelegateForViewType(viewHolder.itemViewType)
        return adapterDelegate.onFailedToRecycleView(viewHolder)
    }

    fun onViewAttachedToWindow(viewHolder : RecyclerView.ViewHolder) {
        val adapterDelegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder> = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onFailedToRecycleView(viewHolder)
    }

    fun onViewDetachedFromWindow(viewHolder : RecyclerView.ViewHolder) {
        val adapterDelegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder> = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onFailedToRecycleView(viewHolder)
    }

    fun getViewType(delegate: AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>) : Int {
        val index = delegates.indexOfValue(delegate)
        if (index == -1) {
            return -1
        }
        return delegates.keyAt(index)
    }

    fun getDelegateForViewType(viewType: Int) : AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder> = delegates.get(viewType)

    private fun Int.toAdapterDelegate(): AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>? = delegates.get(this)
}