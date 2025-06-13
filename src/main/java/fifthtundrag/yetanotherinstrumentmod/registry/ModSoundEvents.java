package fifthtundrag.yetanotherinstrumentmod.registry;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ModSoundEvents {
    /** Stores all of our {@link SoundEvent}s to be registered to our registry when {@link ModSoundEvents#init} is run */
    private static final Map<Identifier, SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

    public static final SoundEvent TUBA_PLAY = register("item.tuba.play");
    public static final SoundEvent SAXOPHONE_PLAY = register("item.saxophone.play");
    public static final SoundEvent CLARINET_PLAY = register("item.clarinet.play");

    private static SoundEvent register(String path) {
        final Identifier identifier = Identifier.of(InstrumentMod.MOD_ID, path);
        final SoundEvent soundEvent = SoundEvent.of(identifier);
        SOUND_EVENTS.put(identifier, soundEvent);
        return soundEvent;
    }

    public static void init() {
        SOUND_EVENTS.forEach((identifier, soundEvent) -> {
            Registry.register(Registries.SOUND_EVENT, identifier, soundEvent);
        });
    }
}
