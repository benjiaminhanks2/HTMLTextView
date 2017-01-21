package be.vrt.ui.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import be.vrt.ui.HTMLTextView
import be.vrt.ui.adapter.delegate.AbsHTMLElementAdapterDelegate
import be.vrt.ui.sample.delegate.ImageViewDelegate
import be.vrt.ui.sample.delegate.QuoteDelegate
import be.vrt.ui.utils.htmlTextView
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    var htmlTextView: HTMLTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            htmlTextView = htmlTextView {
            }.lparams(width = matchParent, height = matchParent)
        }

        htmlTextView?.setHTMLString(this.getString(R.string.example_html))
        htmlTextView?.addAdapterDelegate(QuoteDelegate() as AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>)
        htmlTextView?.addAdapterDelegate(ImageViewDelegate() as AbsHTMLElementAdapterDelegate<RecyclerView.ViewHolder>)
    }
}