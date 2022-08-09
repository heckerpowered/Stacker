package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import heckerpowered.stacker.util.StackerUtil;
import net.minecraftforge.items.ItemStackHandler;

@Mixin(ItemStackHandler.class)
public abstract class ItemStackHandlerMixin {
    @Inject(method = "getSlotLimit", at = @At("HEAD"), cancellable = true, remap = false)
    public void getSlotLimit(int slot, CallbackInfoReturnable<Integer> info) {
        info.setReturnValue(StackerUtil.getMaxStackSize());
    }
}
