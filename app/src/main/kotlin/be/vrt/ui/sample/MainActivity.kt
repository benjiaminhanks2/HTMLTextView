package be.vrt.ui.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import be.vrt.ui.widget.HTMLTextView.htmlTextView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            htmlTextView(context.getString(R.string.example_spv_html))
        }
    }
}