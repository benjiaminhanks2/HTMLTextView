package be.vrt.ui.adapter.layout.style

import android.graphics.Color
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textColor

interface TextualViewStyle : ViewStyle<TextView> {
    companion object {
        val defaultStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
            }
        }

        val H1Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView)
                {
                    textSize = 112F
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val H2Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 56F
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val H3Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 45f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val H4Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 34f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val H5Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 24f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val H6Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 20f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val PStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 15f
                    setLineSpacing(1F, 1.5F)
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }
    }
}