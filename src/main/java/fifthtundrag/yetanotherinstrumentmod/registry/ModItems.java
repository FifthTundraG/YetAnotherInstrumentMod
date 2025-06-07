package fifthtundrag.yetanotherinstrumentmod.registry;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import fifthtundrag.yetanotherinstrumentmod.item.ClarinetItem;
import fifthtundrag.yetanotherinstrumentmod.item.SaxophoneItem;
import fifthtundrag.yetanotherinstrumentmod.item.TubaItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ModItems {
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item.Settings GENERIC_INSTRUMENT_SETTINGS = new Item.Settings().rarity(Rarity.EPIC).maxCount(1);

    public static final Item SAXOPHONE_ITEM = register("saxophone", new SaxophoneItem(GENERIC_INSTRUMENT_SETTINGS));
    public static final Item CLARINET_ITEM = register("clarinet", new ClarinetItem(GENERIC_INSTRUMENT_SETTINGS));
    public static final Item TUBA_ITEM = register("tuba", new TubaItem(GENERIC_INSTRUMENT_SETTINGS));

    private static Item register(String id, Item item) {
        ITEMS.put(Identifier.of(InstrumentMod.MOD_ID, id), item);
        return item;
    }

    public static void init() {
        ITEMS.forEach((identifier, item) -> {
            Registry.register(Registries.ITEM, identifier, item);
            ModItemGroup.addToGroup(item);
        });
    }
}
