package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;

import heckerpowered.stacker.util.StackerUtil;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

@Mixin(ChestBlockEntity.class)
public abstract class ChestBlockEntityMixin implements Container {
    @Override
    public int getMaxStackSize() {
        return StackerUtil.getMaxStackSize();
    }
}
