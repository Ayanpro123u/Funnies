package io.github.ayanpro123u.funnies;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;


public class FunniesParticles {
	public static final DefaultParticleType SCYTHE_SWEEP = FabricParticleTypes.simple();

	public static void register(ModContainer mod) {
		Registry.register(Registries.PARTICLE_TYPE, new Identifier(mod.metadata().id(), "scythe_sweep"), SCYTHE_SWEEP);
		ParticleFactoryRegistry.getInstance().register(SCYTHE_SWEEP, SweepAttackParticle.Factory::new);
	}
}
