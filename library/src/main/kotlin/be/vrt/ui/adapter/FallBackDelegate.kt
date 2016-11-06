package be.vrt.ui.adapter

import android.graphics.Color
import android.view.ViewGroup
import be.vrt.ui.adapter.viewholder.FallBackViewHolder
import be.vrt.ui.model.HTMLElement
import org.jetbrains.anko.*

class FallBackDelegate : AbsHTMLElementAdapterDelegate<FallBackViewHolder>() {

    object COMPANION {
        val textview_id: Int = Int.MAX_VALUE - 1
        val container_id : Int = Int.MAX_VALUE - 2
    }

    override fun onBindViewHolder(item: HTMLElement, viewHolder: FallBackViewHolder, payLoads: List<Any>) = viewHolder.bind(item)

    override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup): FallBackViewHolder {
        val view = parent.context.UI {
            verticalLayout {
                id = COMPANION.container_id
                textView {
                    id = COMPANION.textview_id
                    textSize = 16f
                    textColor = Color.BLACK
                }.lparams(width = matchParent, height = wrapContent)
            }
        }.view
        return FallBackViewHolder(view)
    }
}