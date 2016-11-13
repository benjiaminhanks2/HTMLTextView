package be.vrt.ui.sample.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.sample.delegate.ImageViewDelegate
import com.squareup.picasso.Picasso

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: HTMLElement) {
        val imageView = itemView.findViewById(ImageViewDelegate.imageViewId) as ImageView
        Picasso.with(itemView.context)
                .load(item.src)
                .into(imageView)
    }
}