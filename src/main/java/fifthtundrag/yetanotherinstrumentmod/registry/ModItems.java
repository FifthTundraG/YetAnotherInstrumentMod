package fifthtundrag.yetanotherinstrumentmod.registry;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import fifthtundrag.yetanotherinstrumentmod.item.ClarinetItem;
import fifthtundrag.yetanotherinstrumentmod.item.SaxophoneItem;
import fifthtundrag.yetanotherinstrumentmod.item.TubaItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ModItems {
    private static final Map<ResourceLocation, Item> ITEMS = new LinkedHashMap<>();

    public static final Item.Properties GENERIC_INSTRUMENT_SETTINGS = new Item.Properties().rarity(Rarity.EPIC).stacksTo(1);

    public static final Item SAXOPHONE_ITEM = register("saxophone", new SaxophoneItem(GENERIC_INSTRUMENT_SETTINGS));
    public static final Item CLARINET_ITEM = register("clarinet", new ClarinetItem(GENERIC_INSTRUMENT_SETTINGS));
    public static final Item TUBA_ITEM = register("tuba", new TubaItem(GENERIC_INSTRUMENT_SETTINGS));

    private static Item register(String id, Item item) {
        ITEMS.put(ResourceLocation.fromNamespaceAndPath(InstrumentMod.MOD_ID, id), item);
        return item;
    }

    public static void init() {
        ITEMS.forEach((identifier, item) -> {
            Registry.register(BuiltInRegistries.ITEM, identifier, item);
            ModItemGroup.addToGroup(item);
        });
    }
}
