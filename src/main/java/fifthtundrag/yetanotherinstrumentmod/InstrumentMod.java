package fifthtundrag.yetanotherinstrumentmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fifthtundrag.yetanotherinstrumentmod.item.SaxophoneItem;

public class InstrumentMod implements ModInitializer {
	public static final String MOD_ID = "yetanotherinstrumentmod";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("YetAnotherInstrumentMod");

	public static final Item SAXOPHONE_ITEM = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "saxophone"),
			new SaxophoneItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)));

	private static final ItemGroup INSTRUMENTS_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(SAXOPHONE_ITEM))
			.displayName(Text.translatable("itemGroup.yetanotherinstrumentmod.instruments"))
			.entries((context, entries) -> {
				entries.add(SAXOPHONE_ITEM);
			})
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, "instruments_group"), INSTRUMENTS_GROUP);
	}
}