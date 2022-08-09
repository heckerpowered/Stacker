package heckerpowered.stacker.mixin;

import org.spongepowered.asm.mixin.Mixin;

import heckerpowered.stacker.util.StackerUtil;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.vehicle.AbstractMinecartContainer;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.entity.vehicle.MinecartHopper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.MerchantContainer;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.entity.DropperBlockEntity;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.minecraft.world.level.block.entity.TrappedChestBlockEntity;
import net.minecraftforge.items.wrapper.RecipeWrapper;

@Mixin({ ChestBlockEntity.class, Inventory.class, SimpleContainer.class, AbstractMinecartContainer.class,
        ChestBoat.class, MinecartChest.class, MinecartHopper.class, CraftingContainer.class,
        MerchantContainer.class, PlayerEnderChestContainer.class, ResultContainer.class,
        AbstractFurnaceBlockEntity.class, BarrelBlockEntity.class, BaseContainerBlockEntity.class,
        BlastFurnaceBlockEntity.class, BrewingStandBlockEntity.class, DispenserBlockEntity.class,
        DropperBlockEntity.class, FurnaceBlockEntity.class, HopperBlockEntity.class,
        RandomizableContainerBlockEntity.class, ShulkerBoxBlockEntity.class, SmokerBlockEntity.class,
        TrappedChestBlockEntity.class, CompoundContainer.class, RecipeWrapper.class })
public abstract class ContainerImplMixin implements Container {
    @Override
    public int getMaxStackSize() {
        return StackerUtil.getMaxStackSize();
    }
}
