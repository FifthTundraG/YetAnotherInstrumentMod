package fifthtundrag.yetanotherinstrumentmod.registry;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final Identifier IDENTIFIER = Identifier.of(InstrumentMod.MOD_ID, "item_group");

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SAXOPHONE_ITEM))
            .displayName(Text.translatable("itemGroup.yetanotherinstrumentmod.instruments"))
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, IDENTIFIER, ITEM_GROUP);
    }

    public static void addToGroup(Item item) {
        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, IDENTIFIER)).register(entries -> entries.add(new ItemStack(item)));
    }
}
