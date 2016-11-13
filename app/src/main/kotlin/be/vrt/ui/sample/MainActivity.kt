package be.vrt.ui.sample

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import be.vrt.ui.HTMLTextView
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.model.HTMLElement
import be.vrt.ui.model.type.HTMLTag
import be.vrt.ui.utils.htmlTextView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    var htmlTextView: HTMLTextView? = null
    //todo add sample usage.
    //1. show a full html page rendered with the view showcasing the possibilities. (add toggle to webview)
    //2. show speed comparison between webview let's hope it's faster
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            htmlTextView = htmlTextView {
            }.lparams(width = matchParent, height = matchParent)
        }

        htmlTextView?.setHTMLString(this.getString(R.string.example_spv_html))
        htmlTextView?.addAdapterDelegate(QuoteDelegate() as AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>)
    }

    class QuoteDelegate : AbsHTMLElementAdapterDelegate<QuoteViewHolder>() {
        override val viewType: Int
            get() = 34355

        override fun onBindViewHolder(item: HTMLElement, viewHolder: QuoteViewHolder, payLoads: List<Any>) = viewHolder.bind(item)

        override fun isForViewType(item: HTMLElement, items: List<HTMLElement>, position: Int): Boolean {
            var isForViewType = false
            if (item.htmlTag != null && item.cssClass != null) {
                val cssClass = item.cssClass
                if (cssClass?.size ?: 0 >= 0) {
                    val isQuote = cssClass?.any { it == "quote" } == true
                    isForViewType = item.htmlTag == HTMLTag.P && isQuote
                }
            }
            return isForViewType
        }

        override fun onCreateViewHolder(parent: ViewGroup): QuoteViewHolder {
            val itemView = parent.context.UI {
                textView {
                    id = 0
                    textColor = Color.parseColor("#1f6b6b")
                    typeface = Typeface.MONOSPACE
                    setTypeface(typeface, Typeface.ITALIC)
                    setLineSpacing(1F, 1.6F)
                    textSize = 18f
                    padding = dip(8)
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }.view
            return QuoteViewHolder(itemView)
        }
    }

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: HTMLElement) {
            val textView = itemView.findViewById(0) as TextView
            textView.text = "Quote: ${item.text}"
        }
    }
}