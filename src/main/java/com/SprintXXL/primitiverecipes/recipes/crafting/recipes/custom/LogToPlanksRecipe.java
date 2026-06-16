package com.SprintXXL.primitiverecipes.recipes.crafting.recipes.custom;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class LogToPlanksRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        boolean foundLog = false;

        for (int i = 0; i < inv.getSizeInventory(); i++) {

            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            if (foundLog) {
                return false;
            }

            if (getPlanksForLog(stack).isEmpty()) {
                return false;
            }

            foundLog = true;
        }

        return foundLog;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        for (int i = 0; i < inv.getSizeInventory(); i++) {

            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            return getPlanksForLog(stack);
        }

        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 1;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(Blocks.PLANKS);
    }

    private ItemStack getPlanksForLog(ItemStack logStack) {

        if (logStack.getItem() == Item.getItemFromBlock(Blocks.LOG)) {
            int meta = logStack.getMetadata();

            if (meta == 0) return new ItemStack(Blocks.PLANKS, 2, 0);
            if (meta == 1) return new ItemStack(Blocks.PLANKS, 2, 1);
            if (meta == 2) return new ItemStack(Blocks.PLANKS, 2, 2);
            if (meta == 3) return new ItemStack(Blocks.PLANKS, 2, 3);
        }

        if (logStack.getItem() == Item.getItemFromBlock(Blocks.LOG2)) {
            int meta = logStack.getMetadata();

            if (meta == 0) return new ItemStack(Blocks.PLANKS, 2, 4);
            if (meta == 1) return new ItemStack(Blocks.PLANKS, 2, 5);
        }

        return ItemStack.EMPTY;
    }
}
