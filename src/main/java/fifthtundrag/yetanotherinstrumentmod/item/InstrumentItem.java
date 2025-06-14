package fifthtundrag.yetanotherinstrumentmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InstrumentItem extends Item {
    private final SoundEvent sound;
    public InstrumentItem(Settings settings, SoundEvent sound) {
        super(settings);
        this.sound = sound;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // rotation vector is between -1 and 1, pitch is between 0.5 and 2
        final float pitch = (0.75f * (float) user.getRotationVector().y) + 1.25f;
        user.playSound(this.sound, 1.0F, pitch);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
