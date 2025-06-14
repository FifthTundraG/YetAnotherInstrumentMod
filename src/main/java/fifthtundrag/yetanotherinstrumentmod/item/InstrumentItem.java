package fifthtundrag.yetanotherinstrumentmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class InstrumentItem extends Item {
    private final SoundEvent sound;
    public InstrumentItem(Properties properties, SoundEvent sound) {
        super(properties);
        this.sound = sound;
    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // rotation vector is between -1 and 1, pitch is between 0.5 and 2
        final float pitch = (0.75f * (float) player.getLookAngle().y) + 1.25f;
        // between 0 and 1 (as opposed to -1 and 1)

        player.playSound(this.sound, 1.0F, pitch);
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
