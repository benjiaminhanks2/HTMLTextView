package be.vrt.ui.adapter.layout

import android.view.View
import be.vrt.ui.adapter.layout.style.ViewStyle
import org.jetbrains.anko.applyRecursively

interface Layout<T : View, in S : ViewStyle<T>> {
    val view : T

    fun T.setStyle(style: S) {
        this.applyRecursively {
            style.invoke(this)
        }
    }
}