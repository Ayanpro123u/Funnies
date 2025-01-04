package io.github.ayanpro123u.funnies.items;

import io.github.ayanpro123u.funnies.materials.AmberiteToolMaterial;
import net.minecraft.item.*;

public class ScytheItem extends SwordItem {
	public ScytheItem(AmberiteToolMaterial instance, int attackDamage, float attackSpeed, Item.Settings settings) {
		super(AmberiteToolMaterial.INSTANCE, attackDamage, attackSpeed, settings);
	}

}
