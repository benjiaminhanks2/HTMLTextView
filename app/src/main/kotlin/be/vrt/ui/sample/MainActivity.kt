package be.vrt.ui.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import be.vrt.ui.utils.htmlTextView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    //todo add sample usage.
    //1. show a full html page rendered with the view showcasing the possibilities. (add toggle to webview)
    //2. show speed comparison between webview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            htmlTextView(context.getString(R.string.example_spv_html))
        }
    }
}