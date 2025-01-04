package io.github.ayanpro123u.funnies;

import io.github.ayanpro123u.funnies.enchantments.ReapingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;

public class FunniesEnchantments {

	public static Enchantment REAPING = new ReapingEnchantment();

	public static void register(ModContainer mod) {
		Registry.register(Registries.ENCHANTMENT, new Identifier(mod.metadata().id(), "reaping"), REAPING);
	}

}
