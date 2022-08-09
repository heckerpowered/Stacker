package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import heckerpowered.stacker.util.numeric.NumericUnit;
import net.minecraft.client.renderer.entity.ItemRenderer;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Redirect(method = "renderGuiItemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V", at = @At(value = "INVOKE", target = "Ljava/lang/String;valueOf(I)Ljava/lang/String;", remap = false))
    private String valueOf(int value) {
        return NumericUnit.format(value);
    }
}
