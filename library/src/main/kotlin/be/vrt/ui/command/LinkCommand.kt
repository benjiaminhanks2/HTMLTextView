package be.vrt.ui.command

data class LinkCommand(val textCommand: Command, val link : String) : Command by textCommand