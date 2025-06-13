package fifthtundrag.yetanotherinstrumentmod.item;

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
        user.playSound(this.sound, 1.0F, this.pitch);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
