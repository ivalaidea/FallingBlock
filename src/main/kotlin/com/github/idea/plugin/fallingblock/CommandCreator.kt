package com.github.idea.plugin.fallingblock

import com.github.idea.plugin.fallingblock.Main.Companion.plugin
import com.github.idea.plugin.fallingblock.Main.Companion.quantity
import com.github.syari.spigot.api.command.command
import com.github.syari.spigot.api.command.tab.CommandTabArgument.Companion.argument

object CommandCreator {
    fun register() {
        plugin.command("fallingblock") {
            aliases = listOf("fb", "falling-block")
            tab {
                argument {
                    tab { addAll("start", "stop", "set") }
                }
                execute {
                    when (args.lowerOrNull(0)) {
                        "start" -> {
                            sender.send("ブロックの雨を有効化")
                            Main.isEnable = true
                        }
                        "stop" -> {
                            sender.send("ブロックの雨を無効化")
                            Main.isEnable = false
                        }
                        "set" -> {
                            quantity = args.getOrNull(1)?.toIntOrNull() ?: 1
                            sender.send("ブロックの量を${quantity}に設定しました")
                        }
                    }
                }
            }
        }
    }
}
