package heckerpowered.stacker.util;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.ThreadSafe;

import net.minecraft.FieldsAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;

@MethodsReturnNonnullByDefault
@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
@ThreadSafe
public final class StackerUtil {
    private StackerUtil() {
    }

    public static final int getMaxStackSize() {
        return 10000;
    }
}
