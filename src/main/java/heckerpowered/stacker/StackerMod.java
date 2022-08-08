package heckerpowered.stacker;

import javax.annotation.ParametersAreNonnullByDefault;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mojang.logging.LogUtils;

import net.minecraft.FieldsAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraftforge.fml.common.Mod;

@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@Mod(StackerMod.MODID)
public final class StackerMod {
    /**
     * Define mod id in a common place for everything to reference
     */
    public static final String MODID = "stacker";

    /**
     * Directly reference a slf4j logger
     */
    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Directly reference a slf4j marker
     */
    public static final Marker MARKER = MarkerFactory.getMarker("FORGEMOD");

    public StackerMod() {

    }
}
