package dev.elysium.{{PROJECT_NAME_LOWERCASE}}

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import org.slf4j.Logger
import java.nio.file.Path

@Plugin(
    id = "{{PROJECT_NAME_LOWERCASE}}",
    name = "{{PROJECT_NAME}}",
    version = "1.0.0",
    description = "{{PROJECT_NAME}} template",
    authors = []
)
class Main @Inject constructor(
    val server: ProxyServer,
    val logger: Logger,
    @DataDirectory val dataDirectory: Path
) {

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        logger.info("{{PROJECT_NAME}} успешно инициализирован!")
    }
}
