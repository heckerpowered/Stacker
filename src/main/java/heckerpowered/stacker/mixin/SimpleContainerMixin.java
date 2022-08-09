package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;

import heckerpowered.stacker.util.StackerUtil;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;

@Mixin(SimpleContainer.class)
public abstract class SimpleContainerMixin implements Container {
    @Override
    public int getMaxStackSize() {
        return StackerUtil.getMaxStackSize();
    }
}
