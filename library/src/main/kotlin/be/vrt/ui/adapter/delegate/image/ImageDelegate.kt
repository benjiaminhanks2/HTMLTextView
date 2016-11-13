package be.vrt.ui.adapter.delegate.image

import android.view.ViewGroup
import android.widget.FrameLayout
import be.vrt.ui.adapter.delegate.DefaultHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.image.ImageLayout
import be.vrt.ui.adapter.layout.style.ImageViewStyle
import be.vrt.ui.adapter.viewholder.image.ImageViewHolder
import be.vrt.ui.model.type.HTMLTag

class ImageDelegate : DefaultHTMLElementAdapterDelegate<FrameLayout, ImageViewStyle, ImageLayout, ImageViewHolder>() {
    override fun isForViewType(tag: HTMLTag, position: Int): Boolean = tag == HTMLTag.IMG

    override val viewType: Int
        get() = 1664

    override fun onCreateViewHolder(parent: ViewGroup): ImageViewHolder = ImageViewHolder(ImageLayout(parent.context))
}