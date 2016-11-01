package be.vrt.ui.command

import be.vrt.ui.command.Command

data class ImageCommand(val url : String, val accessibilityText : String) : Command