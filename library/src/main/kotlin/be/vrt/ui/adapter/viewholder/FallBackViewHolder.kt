package be.vrt.ui.adapter.viewholder

import android.util.Log
import be.vrt.ui.adapter.layout.text.TextualLayout
import be.vrt.ui.adapter.viewholder.text.AbsTextualViewHolder
import be.vrt.ui.model.HTMLElement

class FallBackViewHolder(textualView: TextualLayout)
    : AbsTextualViewHolder(textualView) {

    override fun bind(item: HTMLElement) {
        /*if (BuildConfig.DEBUG) {
            textView?.text = "Unknown tag: ${item.htmlTag} ${item.cssClass} :: \r\n${item.text} \n"
        }*/
        Log.d(this.javaClass.simpleName, "Unknown Tag")
    }
}