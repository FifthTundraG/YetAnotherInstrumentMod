package fifthtundrag.yetanotherinstrumentmod.util;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class CustomSounds {
    private CustomSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    // ITEM_METAL_WHISTLE is the name of the custom sound event
    // and is called in the mod to use the custom sound
    public static final SoundEvent TUBA_PLAY = registerSound("tuba_play");
    public static final SoundEvent SAXOPHONE_PLAY = registerSound("saxophone_play");
    public static final SoundEvent CLARINET_PLAY = registerSound("clarinet_play");

    // actual registration of all the custom SoundEvents
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(InstrumentMod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    // This static method starts class initialization, which then initializes
    // the static class variables (e.g. ITEM_METAL_WHISTLE).
    public static void initialize() {
        InstrumentMod.LOGGER.info("Registering " + InstrumentMod.MOD_ID + " Sounds");
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }
}