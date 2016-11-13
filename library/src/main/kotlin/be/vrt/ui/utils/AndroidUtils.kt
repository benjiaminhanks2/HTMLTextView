package be.vrt.ui.utils

import android.support.v4.util.SparseArrayCompat

/**
 * Returns `true` if at least one element matches the given [predicate].
 */
inline fun <E> SparseArrayCompat<E>.findAppropriateViewType(fallBackViewType : Int, predicate: (E) -> Boolean): Int {
    (0..size() -1).forEach {
        val adapterDelegate: E = get(keyAt(it))
        if (predicate(adapterDelegate)) {
            return keyAt(it)
        }
    }
    return fallBackViewType
}