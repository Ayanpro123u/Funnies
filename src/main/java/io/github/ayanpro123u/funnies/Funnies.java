package io.github.ayanpro123u.funnies;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Funnies implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Funnies");


	@Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("Initializing {}", mod.metadata().name());
		FunniesItems.register(mod);
		FunniesEnchantments.register(mod);
		FunniesParticles.register(mod);
		}
	}
