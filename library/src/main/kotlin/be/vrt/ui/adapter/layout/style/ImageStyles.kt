package be.vrt.ui.adapter.layout.style

import android.support.v4.content.ContextCompat
import android.widget.FrameLayout
import be.vrt.ui.R

interface ImageViewStyle : ViewStyle<FrameLayout> {
    companion object {
        val defaultImageViewStyle: ImageViewStyle = object : ImageViewStyle {
            override fun invoke(view: FrameLayout) {
                with(view) {
                    background = ContextCompat.getDrawable(context, R.drawable.imagelayout_bg)
                }
            }
        }
    }
}