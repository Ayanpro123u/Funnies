package io.github.ayanpro123u.funnies;

import io.github.ayanpro123u.funnies.items.RailCannonItem;
import io.github.ayanpro123u.funnies.items.ScytheItem;
import io.github.ayanpro123u.funnies.materials.AmberiteToolMaterial;
import io.github.ayanpro123u.funnies.materials.AmberiteArmorMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import net.minecraft.world.explosion.*;
import java.util.List;

public class FunniesItems {

	public static final Item AMBERITE_INGOT = new Item(new QuiltItemSettings().fireproof().rarity(Rarity.EPIC)) {
		@Override
		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.funnies.amberite_ingot.tooltip_line1").formatted(Formatting.GRAY));
			tooltip.add(Text.translatable("item.funnies.amberite_ingot.tooltip_line2").formatted(Formatting.GRAY));
			tooltip.add(Text.translatable("item.funnies.amberite_ingot.tooltip_line3").formatted(Formatting.GRAY));
			tooltip.add(Text.translatable("item.funnies.amberite_ingot.tooltip_line4").formatted(Formatting.DARK_RED));
		}
	};

	public static final Item PORTABLE_TNT = new Item(new QuiltItemSettings().maxCount(16)) {
		@Override
		public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand mainhand) {
			ItemStack itemStack = user.getStackInHand(mainhand);
			if (!world.isClient) {
				Vec3d lookDir = user.getRotationVec(0.1f);
				Vec3d pos = user.getPos().add(lookDir.multiply(1.5));

				TntEntity tntEntity = new TntEntity(world, pos.x, pos.y + 1.0, pos.z, user);
				tntEntity.setVelocity(lookDir.multiply(1.5));
				int fuse = 20;
				tntEntity.setFuse(fuse);
				Explosion explosion = new Explosion(world, tntEntity, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), 2.0f, false, Explosion.DestructionType.KEEP);
				tntEntity.canExplosionDestroyBlock(explosion, world, tntEntity.getBlockPos(), tntEntity.getBlockStateAtPos(), 2.0f);
				world.spawnEntity(tntEntity);

				world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);

				if (!user.getAbilities().creativeMode) {
					itemStack.decrement(1);
				}

				return TypedActionResult.success(itemStack);
			}
			return TypedActionResult.pass(itemStack);
		}

		@Override
		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.funnies.portable_tnt.tooltip").formatted(Formatting.GRAY));
		}
	};

	public static final Item SCYTHE = new ScytheItem(AmberiteToolMaterial.INSTANCE, 24, -2.0f, new QuiltItemSettings().fireproof().rarity(Rarity.EPIC));

	public static final Item AMBERITE_SWORD = new SwordItem(AmberiteToolMaterial.INSTANCE, 4, -2.4f, new QuiltItemSettings().fireproof().rarity(Rarity.EPIC));

	public static final Item AMBERITE_AXE = new AxeItem(AmberiteToolMaterial.INSTANCE, 14.0f, -3.0f, new QuiltItemSettings().fireproof().rarity(Rarity.EPIC));

	public static final Item AMBERITE_PICKAXE = new PickaxeItem(AmberiteToolMaterial.INSTANCE, 1, -2.8f, new QuiltItemSettings().fireproof().rarity(Rarity.EPIC));

	public static final Item AMBERITE_SHOVEL = new ShovelItem(AmberiteToolMaterial.INSTANCE, 1, -3.0f, new QuiltItemSettings().fireproof().rarity(Rarity.EPIC));

	public static final Item AMBERITE_HOE = new HoeItem(AmberiteToolMaterial.INSTANCE, -3, 0.0f, new QuiltItemSettings().fireproof().rarity(Rarity.EPIC));

	public static final Item AMBERITE_HELMET = new ArmorItem(AmberiteArmorMaterial.INSTANCE, ArmorItem.ArmorSlot.HELMET, new Item.Settings().rarity(Rarity.EPIC));

	public static final Item AMBERITE_CHESTPLATE = new ArmorItem(AmberiteArmorMaterial.INSTANCE, ArmorItem.ArmorSlot.CHESTPLATE, new Item.Settings().rarity(Rarity.EPIC));

	public static final Item AMBERITE_LEGGINGS = new ArmorItem(AmberiteArmorMaterial.INSTANCE, ArmorItem.ArmorSlot.LEGGINGS, new Item.Settings().rarity(Rarity.EPIC));

	public static final Item AMBERITE_BOOTS = new ArmorItem(AmberiteArmorMaterial.INSTANCE, ArmorItem.ArmorSlot.BOOTS, new Item.Settings().rarity(Rarity.EPIC));

	public static final Item AMBERITE_UPGRADE_SMITHING_TEMPLATE = new SmithingTemplateItem(Text.literal("Netherite Equipment").formatted(Formatting.BLUE),
		Text.literal("Amberite Ingot").formatted(Formatting.BLUE),
		Text.translatable("upgrade.netherite_upgrade").formatted(Formatting.GRAY),
		Text.literal("Add netherite armor, weapon or tool"),
		Text.literal("Add amberite ingot"),
		List.of(new Identifier("item/empty_armor_slot_helmet"),
			new Identifier("item/empty_armor_slot_chestplate"), new Identifier("item/empty_armor_slot_leggings"), new Identifier("item/empty_armor_slot_boots")),
		List.of(new Identifier("item/empty_slot_ingot")));

	public static final Item RAIL_CANNON = new RailCannonItem(new QuiltItemSettings().maxCount(1).rarity(Rarity.EPIC));

	public static void register(ModContainer mod) {

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "portable_tnt"), PORTABLE_TNT);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_ingot"), AMBERITE_INGOT);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_sword"), AMBERITE_SWORD);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_axe"), AMBERITE_AXE);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_pickaxe"), AMBERITE_PICKAXE);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_shovel"), AMBERITE_SHOVEL);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_hoe"), AMBERITE_HOE);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_helmet"), AMBERITE_HELMET);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_chestplate"), AMBERITE_CHESTPLATE);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_leggings"), AMBERITE_LEGGINGS);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_boots"), AMBERITE_BOOTS);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "amberite_upgrade_smithing_template"), AMBERITE_UPGRADE_SMITHING_TEMPLATE);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "scythe"), SCYTHE);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "rail_cannon"), RAIL_CANNON);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE_BLOCKS).register(entries -> {
			entries.addItem(PORTABLE_TNT);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addItem(AMBERITE_INGOT);
			entries.addItem(AMBERITE_UPGRADE_SMITHING_TEMPLATE);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.addItem(AMBERITE_SWORD);
			entries.addItem(AMBERITE_AXE);
			entries.addItem(AMBERITE_HELMET);
			entries.addItem(AMBERITE_CHESTPLATE);
			entries.addItem(AMBERITE_LEGGINGS);
			entries.addItem(AMBERITE_BOOTS);
			entries.addItem(SCYTHE);
			entries.addItem(PORTABLE_TNT);
			entries.addItem(RAIL_CANNON);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS_AND_UTILITIES).register(entries -> {
			entries.addItem(AMBERITE_PICKAXE);
			entries.addItem(AMBERITE_AXE);
			entries.addItem(AMBERITE_SHOVEL);
			entries.addItem(AMBERITE_HOE);
			entries.addItem(PORTABLE_TNT);
		});
	}
}
