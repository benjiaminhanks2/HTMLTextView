package be.vrt.ui.adapter.delegate.image

import android.view.ViewGroup
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.adapter.layout.image.ImageLayout
import be.vrt.ui.adapter.viewholder.image.ImageViewHolder
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag

class ImageDelegate : AbsHTMLElementAdapterDelegate<ImageViewHolder>() {
    override val viewType: Int
        get() = 1664

    override fun onBindViewHolder(item: HTMLElement, viewHolder: ImageViewHolder, payLoads: List<Any>) = viewHolder.bind(item)

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
        var isForViewType = false
        if (item.htmlTag != null) {
            isForViewType = item.htmlTag == HTMLTag.IMG
        }
        return isForViewType
    }

    override fun onCreateViewHolder(parent: ViewGroup): ImageViewHolder = ImageViewHolder(ImageLayout(parent.context))
}