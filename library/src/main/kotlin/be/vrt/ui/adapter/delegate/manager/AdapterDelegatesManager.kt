package be.vrt.ui.adapter.delegate.manager

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.adapter.delegate.fallback.FallBackDelegate
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.utils.any

class AdapterDelegatesManager<T : AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>> {

    companion object {
        val FALLBACK_DELEGATE_VIEW_TYPE = Integer.MAX_VALUE - 1
    }

    internal val delegates: SparseArrayCompat<T> = SparseArrayCompat()
    val fallbackDelegate = FallBackDelegate()

    init {
        addDelegate(FALLBACK_DELEGATE_VIEW_TYPE, fallbackDelegate as T)
    }

    fun addDelegate(viewType: Int,
                    delegate: T,
                    allowReplacingDelegate: Boolean = false): AdapterDelegatesManager<T> {
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

    fun removeDelegate(delegate: T): AdapterDelegatesManager<T> {
        val indexToRemove = delegates.indexOfValue(delegate)

        if (indexToRemove >= 0) {
            delegates.removeAt(indexToRemove)
        }
        return this
    }

    fun removeDelegate(viewType: Int): AdapterDelegatesManager<T> {
        delegates.remove(viewType)
        return this
    }

    fun getItemViewType(items: List<HTMLElement>, position: Int): Int =
            if (delegates.any { it.isForViewType(items[position], items, position) }) delegates.keyAt(position) else FALLBACK_DELEGATE_VIEW_TYPE

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val adapterDelegate: T = getDelegateForViewType(viewType)
        return adapterDelegate.onCreateViewHolder(parent)
    }

    fun onBindViewHolder(items: List<HTMLElement>, position: Int, viewHolder: RecyclerView.ViewHolder, payLoads: List<Any> = emptyList()) {
        val adapterDelegate: T = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onBindViewHolder(items[position], viewHolder, payLoads)
    }

    fun onViewRecycled(viewHolder: RecyclerView.ViewHolder) {
        val adapterDelegate: T = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onViewRecycled(viewHolder)
    }

    fun onFailedToRecycleView(viewHolder: RecyclerView.ViewHolder): Boolean {
        val adapterDelegate: T = getDelegateForViewType(viewHolder.itemViewType)
        return adapterDelegate.onFailedToRecycleView(viewHolder)
    }

    fun onViewAttachedToWindow(viewHolder: RecyclerView.ViewHolder) {
        val adapterDelegate: T = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onFailedToRecycleView(viewHolder)
    }

    fun onViewDetachedFromWindow(viewHolder: RecyclerView.ViewHolder) {
        val adapterDelegate: T = getDelegateForViewType(viewHolder.itemViewType)
        adapterDelegate.onFailedToRecycleView(viewHolder)
    }

    val T.viewType: Int
        get() = if (delegates.indexOfValue(this) == -1) -1 else delegates.keyAt(delegates.indexOfValue(this))

    fun getDelegateForViewType(viewType: Int): T = delegates.get(viewType)
}