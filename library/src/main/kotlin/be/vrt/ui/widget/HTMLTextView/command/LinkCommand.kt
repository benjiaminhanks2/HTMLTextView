package be.vrt.ui.widget.HTMLTextView.command

data class LinkCommand(val textCommand: Command, val link : String) : Command by textCommand