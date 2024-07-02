package fifthtundrag.yetanotherinstrumentmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SaxophoneItem extends Item {
    public SaxophoneItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), 3.0F, 1.0F);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
