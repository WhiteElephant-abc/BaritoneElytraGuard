package io.github.whiteelephantabc.elytraguard.client

import baritone.api.BaritoneAPI

object BaritoneState {
	fun isGroundPathing(): Boolean = try {
		val baritone = BaritoneAPI.getProvider().primaryBaritone
		val pathing = baritone.pathingBehavior
		val paused = pathing.hasPath() && !pathing.isPathing
		!baritone.elytraProcess.isActive && pathing.goal != null && !paused
	} catch (_: Throwable) {
		false
	}
}
