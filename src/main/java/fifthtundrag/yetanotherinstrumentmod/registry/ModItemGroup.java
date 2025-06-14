package fifthtundrag.yetanotherinstrumentmod.registry;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {
    public static final ResourceLocation RESOURCE_LOCATION = ResourceLocation.fromNamespaceAndPath(InstrumentMod.MOD_ID, "item_group");

    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SAXOPHONE_ITEM))
            .title(Component.translatable("itemGroup.yetanotherinstrumentmod.instruments"))
            .build();

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RESOURCE_LOCATION, CREATIVE_MODE_TAB);
    }

    public static void addToGroup(net.minecraft.world.item.Item item) {
        ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, RESOURCE_LOCATION)).register(entries -> entries.prepend(new ItemStack(item)));
    }
}
