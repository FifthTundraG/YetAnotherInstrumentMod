package fifthtundrag.yetanotherinstrumentmod.registry;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ModSoundEvents {
    /** Stores all of our {@link SoundEvent}s to be registered to our registry when {@link ModSoundEvents#init} is run */
    private static final Map<ResourceLocation, net.minecraft.sounds.SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

    public static final SoundEvent TUBA_PLAY = register("item.tuba.play");
    public static final SoundEvent SAXOPHONE_PLAY = register("item.saxophone.play");
    public static final SoundEvent CLARINET_PLAY = register("item.clarinet.play");

    private static SoundEvent register(String path) {
        final ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(InstrumentMod.MOD_ID, path);
        final SoundEvent soundEvent = SoundEvent.createVariableRangeEvent(identifier);
        SOUND_EVENTS.put(identifier, soundEvent);
        return soundEvent;
    }

    public static void init() {
        SOUND_EVENTS.forEach((identifier, soundEvent) -> {
            Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, soundEvent);
        });
    }
}
