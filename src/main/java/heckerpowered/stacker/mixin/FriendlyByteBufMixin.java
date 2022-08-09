package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;

@Mixin(FriendlyByteBuf.class)
public class FriendlyByteBufMixin {

    @Redirect(method = "writeItemStack", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/FriendlyByteBuf;writeByte(I)Lio/netty/buffer/ByteBuf;"))
    public ByteBuf writeByte(FriendlyByteBuf buf, int value) {
        return buf.writeInt(value);
    }

    @SuppressWarnings("deprecation")
    @Inject(method = "readItem", at = @At("HEAD"), cancellable = true)
    public void readItem(CallbackInfoReturnable<ItemStack> info) {
        final var self = (FriendlyByteBuf) (Object) this;
        if (self.readBoolean()) {
            final var item = self.readById(Registry.ITEM);
            final var stack = new ItemStack(item, self.readInt());
            stack.readShareTag(self.readNbt());
            info.setReturnValue(stack);
        } else {
            info.setReturnValue(ItemStack.EMPTY);
        }
    }
}
