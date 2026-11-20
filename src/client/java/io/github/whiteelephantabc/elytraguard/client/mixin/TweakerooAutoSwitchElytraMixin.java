package io.github.whiteelephantabc.elytraguard.client.mixin;

import io.github.whiteelephantabc.elytraguard.client.BaritoneState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "fi.dy.masa.tweakeroo.util.InventoryUtils", remap = false)
public class TweakerooAutoSwitchElytraMixin {
	@Inject(method = "equipBestElytra", at = @At("HEAD"), cancellable = true, remap = false)
	private static void elytraguard$skipDuringBaritonePathing(CallbackInfo ci) {
		if (BaritoneState.INSTANCE.isGroundPathing()) {
			ci.cancel();
		}
	}
}
