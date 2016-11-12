package be.vrt.ui.utils

import android.support.v4.util.SparseArrayCompat

/**
 * Returns `true` if at least one element matches the given [predicate].
 */
inline fun <T> SparseArrayCompat<T>.forEachIndexed(action: (Int,T) -> Unit): Unit {
    (0..size()).forEach { action(it,get(it)) }
}