package be.vrt.ui.sample.delegate

import android.view.ViewGroup
import android.widget.ImageView
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag
import be.vrt.ui.sample.viewholder.ImageViewHolder
import org.jetbrains.anko.UI
import org.jetbrains.anko.dip
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.imageView

class ImageViewDelegate : AbsHTMLElementAdapterDelegate<ImageViewHolder>() {

    override val viewType: Int = 2
    override fun onBindViewHolder(item: HTMLElement, viewHolder: ImageViewHolder, payLoads: List<Any>) = viewHolder.bind(item)

    companion object { val imageViewId = 43 }

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
        var isForViewType = false
        if (item.htmlTag != null) {
            isForViewType = item.htmlTag == HTMLTag.IMG
        }
        return isForViewType
    }

    override fun onCreateViewHolder(parent: ViewGroup): ImageViewHolder {
        val itemView = parent.context.UI {
            frameLayout {
                imageView {
                    id = imageViewId
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = parent.width, height = dip(200))
            }
        }.view
        return ImageViewHolder(itemView)
    }
}