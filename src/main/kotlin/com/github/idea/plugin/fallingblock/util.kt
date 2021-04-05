package com.github.idea.plugin.fallingblock

import com.github.syari.spigot.api.string.toColor
import org.bukkit.command.CommandSender

fun CommandSender.send(message: String) {
    sendMessage("&b[FallingBlock] &r$message".toColor())
}
