package fifthtundrag.yetanotherinstrumentmod.registry;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import fifthtundrag.yetanotherinstrumentmod.item.SaxophoneItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item SAXOPHONE_ITEM = register("saxophone", new SaxophoneItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)));

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
