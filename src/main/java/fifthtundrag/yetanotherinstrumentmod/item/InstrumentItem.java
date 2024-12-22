package fifthtundrag.yetanotherinstrumentmod.item;

import fifthtundrag.yetanotherinstrumentmod.InstrumentMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InstrumentItem extends Item {
    private final float pitch;
    private final SoundEvent sound;
    public InstrumentItem(SoundEvent sound, float pitch, Settings settings) {
        super(settings);
        this.pitch = pitch;
        this.sound = sound;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        user.playSound(SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), 5.0F, this.pitch);
        user.playSound(this.sound, 1.0F, this.pitch);
        InstrumentMod.LOGGER.info("playing {}", this.sound.toString());
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
