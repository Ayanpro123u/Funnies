package io.github.ayanpro123u.funnies.materials;

import io.github.ayanpro123u.funnies.FunniesItems;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class AmberiteArmorMaterial implements ArmorMaterial {
	@Override
	public int getDurability(ArmorItem.ArmorSlot slot) {
		return 5000;
	}

	@Override
	public int getProtection(ArmorItem.ArmorSlot slot) {
		return 40;
	}

	@Override
	public int getEnchantability() {
		return 100;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(FunniesItems.AMBERITE_INGOT);
	}

	@Override
	public String getName() {
		return "amberite"; // You need a name here for logging, etc.
	}

	@Override
	public float getToughness() {
		return 128;
	}

	@Override
	public float getKnockbackResistance() {
		return 2;
	}

	@Override
	public @NotNull Identifier getTexture() {
		return new Identifier("funnies:textures/models/armor/amberite");
	}

	public static final AmberiteArmorMaterial INSTANCE = new AmberiteArmorMaterial();
}
