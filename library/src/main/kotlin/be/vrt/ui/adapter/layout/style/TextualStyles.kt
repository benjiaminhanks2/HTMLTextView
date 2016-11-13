package be.vrt.ui.adapter.layout.style

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.widget.TextView
import be.vrt.ui.R
import be.vrt.ui.model.HTMLElement
import org.jetbrains.anko.*

//TODO: Add support for nightMode. Like Medium
interface TextualViewStyle : ViewStyle<TextView> {
    companion object {
        val fallBackTextStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    context.configuration(nightMode = true) {

                    }
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
                    setLineSpacing(1F, 1.1F)
                    textColor = ContextCompat.getColor(context, R.color.material_gray_900)
                    padding = dip(8)
                }
            }
        }

        val display4Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(defaultStyle)
                    typeface = Typeface.DEFAULT_BOLD
                    textSize = 112f
                }
            }
        }

        val display3Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(defaultStyle)
                    typeface = Typeface.DEFAULT_BOLD
                    textSize = 56f
                }
            }
        }

        val display2Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(defaultStyle)
                    typeface = Typeface.DEFAULT_BOLD
                    textSize = 45f
                }
            }
        }

        val display1Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(defaultStyle)
                    typeface = Typeface.DEFAULT_BOLD
                    textSize = 34f
                }
            }
        }

        val headLineStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(defaultStyle)
                    typeface = Typeface.DEFAULT_BOLD
                    textSize = 24f
                }
            }
        }

        val titleStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(defaultStyle)
                    typeface = Typeface.DEFAULT_BOLD
                    textSize = 20f
                }
            }
        }

        val body2Style: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(defaultStyle)
                    textSize = 16F
                    setLineSpacing(1F, 1.35F)
                }
            }
        }

        val linkStyle: TextualViewStyle = object : TextualViewStyle {
            override fun invoke(textView: TextView) {
                with(textView) {
                    apply(body2Style)
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