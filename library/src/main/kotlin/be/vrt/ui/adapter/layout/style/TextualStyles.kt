package be.vrt.ui.adapter.layout.style

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.widget.TextView
import be.vrt.ui.R
import be.vrt.ui.model.HTMLElement
import org.jetbrains.anko.dip
import org.jetbrains.anko.onClick
import org.jetbrains.anko.padding
import org.jetbrains.anko.textColor

//TODO: chain styles
interface TextualViewStyle : ViewStyle<TextView> {
    companion object {
        val fallBackTextStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 15f
                    setLineSpacing(1F, 1.5F)
                    padding = dip(8)
                    textColor = Color.RED
                    background = ContextCompat.getDrawable(textView.context, R.drawable.fallback_textview_bg)
                }
            }
        }

        val defaultStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 15f
                    setLineSpacing(1F, 1.5F)
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val display4Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView)
                {
                    textSize = 112F
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val display3Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 56F
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val display2Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 45f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val display1Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 34f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val headLineStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 24f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val titleStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 20f
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val body2Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 15f
                    setLineSpacing(1F, 1.5F)
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                }
            }
        }

        val linkStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    textSize = 15f
                    setLineSpacing(1F, 1.5F)
                    padding = dip(8)
                    textColor = Color.parseColor("#212121")
                    paintFlags = Paint.UNDERLINE_TEXT_FLAG

                    //This is just a POC
                    onClick {
                        val tag: HTMLElement = it?.tag as HTMLElement
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(tag.href)
                        startActivity(textView.context, intent, null)
                    }
                }
            }
        }
    }
}