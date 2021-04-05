package com.github.idea.plugin.fallingblock
import com.github.syari.spigot.api.scheduler.runTaskTimer
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        internal lateinit var plugin: JavaPlugin
        var isEnable = false
    }

    init {
        plugin = this
    }

    override fun onEnable() {
        CommandCreator.register()
        runTaskTimer(1 * 20, async = false) {
            if (isEnable) {
                server.onlinePlayers.forEach {
                    val location = it.location.block.location.add((-10..10).random().toDouble(), 20.0, (-10..10).random().toDouble())
                    val material = Material.values().filter(Material::isBlock).random()
                    it.world.spawnFallingBlock(location, material.createBlockData())
                }
            }
        }
    }
}
