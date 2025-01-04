package io.github.ayanpro123u.funnies.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class ReapingEnchantment extends Enchantment {
	public ReapingEnchantment() {
		super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	public int getMinPower(int level) {
		return 1;
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity livingEntity) {
			// Calculate the direction vector (from target to user)
			double dx = user.getX() - target.getX();
			double dy = user.getY() - target.getY();
			double dz = user.getZ() - target.getZ();

			// Normalize the vector
			double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
			if (distance > 0) {
				dx /= distance;
				dy /= distance;
				dz /= distance;
			}

			// Apply the pull using addVelocity.
			livingEntity.addVelocity(dx * level, dy * level, dz * level);
		}
		if (target instanceof PlayerEntity playerEntity) {
			// Calculate the direction vector (from target to user)
			double dx = user.getX() - target.getX();
			double dy = user.getY() - target.getY();
			double dz = user.getZ() - target.getZ();

			// Normalize the vector
			double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
			if (distance > 0) {
				dx /= distance;
				dy /= distance;
				dz /= distance;
			}

			// Apply the pull using addVelocity.
			playerEntity.addVelocity(dx * level, dy * level, dz * level);
		}
		super.onTargetDamaged(user, target, level);
	}
}
