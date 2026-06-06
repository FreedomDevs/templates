package dev.elysium.{{PROJECT_NAME_LOWERCASE}}

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
  override fun onEnable() {
    logger.info("{{PROJECT_NAME}} включен.")
  }

  override fun onDisable() {
    logger.info("{{PROJECT_NAME}} выключен.")
  }
}
