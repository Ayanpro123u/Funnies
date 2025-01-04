package io.github.ayanpro123u.funnies.materials;

import io.github.ayanpro123u.funnies.FunniesItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AmberiteToolMaterial implements ToolMaterial {
	@Override
	public int getDurability() {
		return 5000;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 37F;
	}

	@Override
	public float getAttackDamage() {
		return 15F;
	}

	@Override
	public int getMiningLevel() {
		return 4;
	}

	@Override
	public int getEnchantability() {
		return 100;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(FunniesItems.AMBERITE_INGOT);
	}

	public static final AmberiteToolMaterial INSTANCE = new AmberiteToolMaterial();
}
