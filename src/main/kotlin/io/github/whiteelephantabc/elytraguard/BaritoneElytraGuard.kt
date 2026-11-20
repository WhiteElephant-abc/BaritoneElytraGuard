package io.github.whiteelephantabc.elytraguard

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object BaritoneElytraGuard : ModInitializer {
	private val LOGGER = LoggerFactory.getLogger("elytraguard")

	override fun onInitialize() {
		LOGGER.info("BaritoneElytraGuard loaded; Tweakeroo auto elytra switching will be suppressed while Baritone paths on the ground")
	}
}
