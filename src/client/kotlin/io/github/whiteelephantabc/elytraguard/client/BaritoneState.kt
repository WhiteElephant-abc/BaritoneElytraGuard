package io.github.whiteelephantabc.elytraguard.client

import baritone.api.BaritoneAPI

object BaritoneState {
	fun isGroundPathing(): Boolean = try {
		val baritone = BaritoneAPI.getProvider().primaryBaritone
		!baritone.elytraProcess.isActive && baritone.pathingBehavior.goal != null
	} catch (_: Throwable) {
		false
	}
}
