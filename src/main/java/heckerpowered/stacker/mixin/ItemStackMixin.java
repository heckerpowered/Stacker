package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    @Final
    protected abstract int getMaxDamage();

    @Shadow
    @Mutable
    private int count;

    @Inject(method = "getMaxStackSize", at = @At("HEAD"), cancellable = true)
    public final void getMaxStackSize(CallbackInfoReturnable<Integer> info) {
        if (getMaxDamage() == 0) {
            info.setReturnValue(Integer.MAX_VALUE);
        }
    }

    /**
     * pCompoundTag.putByte("Count", (byte)this.count); -> compoundTag.putInt("Count", count);
     */
    @Redirect(method = "save", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/CompoundTag;putByte(Ljava/lang/String;B)V"))
    public void putByte(CompoundTag compoundTag, String key, byte value) {
        compoundTag.putInt("Count", count);
    }

    @Inject(method = "<init>(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    public void getByte(CompoundTag compoundTag, CallbackInfo info) {
        count = compoundTag.getInt("Count");
    }
}
