package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;

import heckerpowered.stacker.util.StackerUtil;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;

@Mixin(Inventory.class)
public abstract class InventoryMixin implements Container {
    @Override
    public int getMaxStackSize() {
        return StackerUtil.getMaxStackSize();
    }
}
