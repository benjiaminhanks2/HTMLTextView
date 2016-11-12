package be.vrt.ui.utils

import android.support.v4.util.SparseArrayCompat

/**
 * Returns `true` if at least one element matches the given [predicate].
 */
inline fun <T> SparseArrayCompat<out T>.any(predicate: (T) -> Boolean): Boolean {
    (0..size()).forEachIndexed { index, t -> if (predicate(get(index))) return true }
    return false
}