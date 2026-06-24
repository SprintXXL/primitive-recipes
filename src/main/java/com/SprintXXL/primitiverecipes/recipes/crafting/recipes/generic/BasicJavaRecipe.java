package com.SprintXXL.primitiverecipes.recipes.crafting.recipes.generic;

import com.SprintXXL.primitiverecipeapi.api.RecipeResourceMatcher;
import com.SprintXXL.primitiverecipeapi.api.RecipeResourceResolver;
import com.SprintXXL.primitiverecipeapi.crafting.CraftingRecipe;
import com.SprintXXL.primitiverecipeapi.crafting.data.BasicRecipeData;
import com.SprintXXL.primitiverecipeapi.crafting.shape.CraftingRecipeShape;
import com.SprintXXL.primitiverecipeapi.crafting.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipeapi.crafting.shape.ShapelessRecipe;
import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;
import com.SprintXXL.primitiverecipeapi.resources.recipe.RemainingBehavior;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.List;

import static com.SprintXXL.primitiverecipes.Reference.MODID;

public class BasicJavaRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private final CraftingRecipe definition;
    private final BasicRecipeData data;

    public BasicJavaRecipe(CraftingRecipe definition) {

        this.definition = definition;
        this.data = (BasicRecipeData) definition.getData();

        setRegistryName(new ResourceLocation(MODID, definition.getID()));
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        CraftingRecipeShape shape = data.getShape();

        if (shape instanceof ShapelessRecipe) {
            return matchesShapeless(inv, (ShapelessRecipe) shape);
        }

        if (shape instanceof ShapedRecipe) {
            return matchesShaped(inv, (ShapedRecipe) shape);
        }

        return false;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {

        NonNullList<ItemStack> remaining = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        CraftingRecipeShape shape = data.getShape();

        if (shape instanceof ShapelessRecipe) {
            applyShapelessRemainingItems(inv, remaining);
        }

        if (shape instanceof ShapedRecipe) {
            applyShapedRemainingItems(inv, remaining, (ShapedRecipe) shape);
        }

        return remaining;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return RecipeResourceResolver.createStack(data.getOutput());
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return RecipeResourceResolver.createStack(data.getOutput());
    }

    private void applyShapelessRemainingItems(InventoryCrafting inv, NonNullList<ItemStack> remaining) {

        for (int i = 0; i < inv.getSizeInventory(); i++) {

            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            RecipeResource recipeResource = findMatchingRecipeResource(stack);

            applyRemainingBehavior(
                    remaining,
                    i,
                    stack,
                    recipeResource
            );
        }
    }

    private void applyShapedRemainingItems(InventoryCrafting inv, NonNullList<ItemStack> remaining, ShapedRecipe shape) {

        int[] offset = findMatchingOffset(inv, shape);

        if (offset == null) {
            return;
        }

        int offsetX = offset[0];
        int offsetY = offset[1];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                ItemStack stack = inv.getStackInRowAndColumn(x, y);

                if (stack.isEmpty()) {
                    continue;
                }

                int patternX = x - offsetX;
                int patternY = y - offsetY;

                RecipeResource recipeResource = getExpectedRecipeResourceAt(shape, patternX, patternY);

                int slot = x + y * 3;

                applyRemainingBehavior(
                        remaining,
                        slot,
                        stack,
                        recipeResource
                );
            }
        }
    }

    private void applyRemainingBehavior(NonNullList<ItemStack> remaining, int slot, ItemStack stack, RecipeResource recipeResource) {

        if (recipeResource == null) {
            return;
        }

        if (recipeResource.getRemainingBehavior() == RemainingBehavior.DAMAGE) {

            ItemStack damaged = stack.copy();
            damaged.setCount(1);
            damaged.setItemDamage(damaged.getItemDamage() + 1);

            if (damaged.getItemDamage() < damaged.getMaxDamage()) {
                remaining.set(slot, damaged);
            }
        }
    }

    private boolean matchesShapeless(InventoryCrafting inv, ShapelessRecipe shape) {

        List<RecipeResource> remainingRecipeResources = new ArrayList<>(shape.getIngredients());

        for (int i = 0; i < inv.getSizeInventory(); i++) {

            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            boolean foundMatch = false;

            for (int j = 0; j < remainingRecipeResources.size(); j++) {

                RecipeResource expected = remainingRecipeResources.get(j);

                if (RecipeResourceMatcher.matches(expected, stack)) {
                    remainingRecipeResources.remove(j);
                    foundMatch = true;
                    break;
                }
            }

            if (!foundMatch) {
                return false;
            }
        }

        return remainingRecipeResources.isEmpty();
    }

    private boolean matchesShaped(InventoryCrafting inv, ShapedRecipe shape) {

        for (int offsetX = 0; offsetX <= 3 - getPatternWidth(shape); offsetX++) {
            for (int offsetY = 0; offsetY <= 3 - getPatternHeight(shape); offsetY++) {

                if (matchesShapedAt(inv, shape, offsetX, offsetY)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matchesShapedAt(InventoryCrafting inv, ShapedRecipe shape, int offsetX, int offsetY) {

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {

                ItemStack stack = inv.getStackInRowAndColumn(x, y);

                int patternX = x - offsetX;
                int patternY = y - offsetY;

                RecipeResource expected = getExpectedRecipeResourceAt(shape, patternX, patternY);

                if (!RecipeResourceMatcher.matches(expected, stack)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getPatternHeight(ShapedRecipe shape) {
        return shape.getPattern().length;
    }

    private int getPatternWidth(ShapedRecipe shape) {

        int width = 0;

        for (String row : shape.getPattern()) {

            if (row.length() > width) {
                width = row.length();
            }
        }

        return width;
    }

    private RecipeResource findMatchingRecipeResource(ItemStack stack) {

        CraftingRecipeShape shape = data.getShape();

        if (!(shape instanceof ShapelessRecipe)) {
            return null;
        }

        ShapelessRecipe shapelessRecipe = (ShapelessRecipe) shape;

        for (RecipeResource recipeResource : shapelessRecipe.getIngredients()) {

            if (RecipeResourceMatcher.matches(recipeResource, stack)) {
                return recipeResource;
            }
        }

        return null;
    }

    private RecipeResource getExpectedRecipeResourceAt(ShapedRecipe shape, int x, int y) {

        String[] pattern = shape.getPattern();

        if (y < 0 || y >= pattern.length) {
            return null;
        }

        String row = pattern[y];

        if (x < 0 || x >= row.length()) {
            return null;
        }

        char symbol = row.charAt(x);

        if (symbol == ' ') {
            return null;
        }

        return shape.getKeys().get(symbol);
    }

    private int[] findMatchingOffset(InventoryCrafting inv, ShapedRecipe shape) {

        for (int offsetX = 0; offsetX <= 3 - getPatternWidth(shape); offsetX++) {
            for (int offsetY = 0; offsetY <= 3 - getPatternHeight(shape); offsetY++) {

                if (matchesShapedAt(inv, shape, offsetX, offsetY)) {
                    return new int[]{offsetX, offsetY};
                }
            }
        }

        return null;
    }
}