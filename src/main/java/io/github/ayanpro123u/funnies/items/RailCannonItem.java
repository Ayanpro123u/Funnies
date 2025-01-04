package io.github.ayanpro123u.funnies.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RailCannonItem extends Item {

	public static final int RANGE = 5000;

	public RailCannonItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		launchProjectile(world, user, user.getStackInHand(hand));
		return TypedActionResult.pass(user.getStackInHand(hand));
	}

	private void launchProjectile(World world, PlayerEntity player, ItemStack stack) {
		ArrowEntity arrow = new ArrowEntity(world, player);
		arrow.setProperties(player, player.getPitch(), player.getYaw(), 0.0F, 2 /20f, 1.0F);
		arrow.setVelocity(player.getRotationVector().multiply(RANGE));
		arrow.setDamage(arrow.getDamage() + RANGE);
		arrow.setOwner(player);
		arrow.setOnFireFor(100);
		world.spawnEntity(arrow);
	}

}
