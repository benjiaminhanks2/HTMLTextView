package be.vrt.ui.adapter.viewholder.image

import android.widget.FrameLayout
import be.vrt.ui.adapter.layout.image.ImageLayout
import be.vrt.ui.adapter.layout.style.ImageViewStyle
import be.vrt.ui.adapter.viewholder.AbsViewHolder
import be.vrt.ui.model.HTMLElement

class ImageViewHolder(imageLayout: ImageLayout) : AbsViewHolder<FrameLayout, ImageViewStyle, ImageLayout>(imageLayout) {
    override fun bind(item: HTMLElement) {}
}