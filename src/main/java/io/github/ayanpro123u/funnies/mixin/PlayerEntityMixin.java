package io.github.ayanpro123u.funnies.mixin;

import io.github.ayanpro123u.funnies.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

	@Inject(method = "spawnSweepAttackParticles", at = @At("HEAD"), cancellable = true)
	private void spawnCustomSweepParticles(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;
		if (player.getMainHandStack().getItem() == FunniesItems.SCYTHE) {
            double d = -MathHelper.sin(player.getYaw() * ((float)Math.PI / 180F));
            double e = MathHelper.cos(player.getYaw() * ((float)Math.PI / 180F));
            if (player.getWorld() instanceof ServerWorld) {
                ((ServerWorld)player.getWorld()).spawnParticles(FunniesParticles.SCYTHE_SWEEP, player.getX() + d, player.getBodyY(0.5D), player.getZ() + e, 0, d, 0.0D, e, 0.0D);
			}
            ci.cancel();
		}
	}
}
