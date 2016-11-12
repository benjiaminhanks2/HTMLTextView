package be.vrt.ui.utils

import android.support.v4.util.SparseArrayCompat

/**
 * Returns `true` if at least one element matches the given [predicate].
 */
inline fun <E> SparseArrayCompat<E>.findAppropriateViewType(fallBackViewType : Int, predicate: (E?) -> Boolean): Int {
    var viewType : Int = fallBackViewType
    (0..size()).forEach {
        val adapterDelegate: E? = get(it)
        if (predicate(adapterDelegate)) {
            viewType = keyAt(it)
            return@forEach
        }
    }
    return viewType
}