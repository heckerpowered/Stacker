package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import heckerpowered.stacker.util.StackerUtil;
import net.minecraft.world.Container;
import net.minecraftforge.items.ItemStackHandler;

@Mixin(ItemStackHandler.class)
public abstract class ItemStackHandlerMixin implements Container {
    @Inject(method = "getSlotLimit", at = @At("HEAD"), cancellable = true)
    public void getSlotLimit(int slot, CallbackInfoReturnable<Integer> info) {
        info.setReturnValue(StackerUtil.getMaxStackSize());
    }
}
