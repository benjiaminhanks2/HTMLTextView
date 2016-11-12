package be.vrt.ui.adapter.layout.style

import android.graphics.Color
import android.widget.TextView
import org.jetbrains.anko.textColor

interface TextualViewStyle : ViewStyle<TextView> {
    companion object {
        val defaultStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) { }
        }

        val H1Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView)
                {
                    textSize = 16f
                    textColor = Color.GREEN
                }
            }
        }

        val H2Style: (TextView) -> Unit = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 14f
                    textColor = Color.RED
                }
            }
        }

        val H3Style: (TextView) -> Unit = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 13f
                    textColor = Color.RED
                }
            }
        }

        val H4Style: (TextView) -> Unit = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 12f
                    textColor = Color.RED
                }
            }
        }

        val H5Style: (TextView) -> Unit = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 11f
                    textColor = Color.RED
                }
            }
        }

        val H6Style: (TextView) -> Unit = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 10f
                    textColor = Color.RED
                }
            }
        }
    }
}