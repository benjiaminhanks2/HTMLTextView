package be.vrt.ui.adapter.layout.image

import android.content.Context
import android.widget.FrameLayout
import be.vrt.ui.adapter.layout.Layout
import be.vrt.ui.adapter.layout.style.ImageViewStyle
import org.jetbrains.anko.UI
import org.jetbrains.anko.dip
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent

class ImageLayout(val context: Context, val imageViewStyle: ImageViewStyle = ImageViewStyle.defaultImageViewStyle) : Layout<FrameLayout, ImageViewStyle> {
    override val view: FrameLayout by lazy {
        context.UI {
            frameLayout {
                lparams(width = matchParent, height = dip(250))
            }.setStyle(imageViewStyle)
        }.view as FrameLayout
    }
}