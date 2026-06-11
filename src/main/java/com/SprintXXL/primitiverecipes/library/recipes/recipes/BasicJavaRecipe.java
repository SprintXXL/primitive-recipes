package com.SprintXXL.primitiverecipes.library.recipes.recipes;

import com.SprintXXL.primitiverecipes.library.recipes.RecipeDefinition;
import com.SprintXXL.primitiverecipes.library.recipes.data.RemainingBehavior;
import com.SprintXXL.primitiverecipes.library.recipes.data.java.BasicRecipeData;
import com.SprintXXL.primitiverecipes.library.recipes.data.RecipeIngredient;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.RecipeShape;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.ShapelessRecipe;
import com.SprintXXL.primitiverecipes.library.resources.ResourceResolver;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
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

    private final RecipeDefinition definition;
    private final BasicRecipeData data;

    public BasicJavaRecipe(RecipeDefinition definition) {

        this.definition = definition;
        this.data = (BasicRecipeData) definition.getData();

        setRegistryName(new ResourceLocation(MODID, definition.getID()));
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        RecipeShape shape = data.getShape();

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

        RecipeShape shape = data.getShape();

        if (shape instanceof ShapelessRecipe) {
            applyShapelessRemainingItems(inv, remaining, (ShapelessRecipe) shape);
        }

        if (shape instanceof ShapedRecipe) {
            applyShapedRemainingItems(inv, remaining, (ShapedRecipe) shape);
        }

        return remaining;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return ResourceResolver.createStack(data.getOutput(), data.getCount());
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ResourceResolver.createStack(data.getOutput(), data.getCount());
    }

    private void applyShapelessRemainingItems(InventoryCrafting inv, NonNullList<ItemStack> remaining, ShapelessRecipe shape) {

        for (int i = 0; i < inv.getSizeInventory(); i++) {

            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            RecipeIngredient ingredient = findMatchingIngredient(stack);

            applyRemainingBehavior(
                    remaining,
                    i,
                    stack,
                    ingredient
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

                RecipeIngredient ingredient = getExpectedIngredientAt(shape, patternX, patternY);

                int slot = x + y * 3;

                applyRemainingBehavior(
                        remaining,
                        slot,
                        stack,
                        ingredient
                );
            }
        }
    }

    private void applyRemainingBehavior(NonNullList<ItemStack> remaining, int slot, ItemStack stack, RecipeIngredient ingredient) {

        if (ingredient == null) {
            return;
        }

        if (ingredient.getRemainingBehavior() == RemainingBehavior.DAMAGE) {

            ItemStack damaged = stack.copy();
            damaged.setCount(1);
            damaged.setItemDamage(damaged.getItemDamage() + 1);

            if (damaged.getItemDamage() < damaged.getMaxDamage()) {
                remaining.set(slot, damaged);
            }
        }
    }

    private boolean matchesShapeless(InventoryCrafting inv, ShapelessRecipe shape) {

        List<RecipeIngredient> remainingIngredients = new ArrayList<>(shape.getIngredients());

        for (int i = 0; i < inv.getSizeInventory(); i++) {

            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            boolean foundMatch = false;

            for (int j = 0; j < remainingIngredients.size(); j++) {

                RecipeIngredient expected = remainingIngredients.get(j);

                if (matchesResource(stack, expected)) {
                    remainingIngredients.remove(j);
                    foundMatch = true;
                    break;
                }
            }

            if (!foundMatch) {
                return false;
            }
        }

        return remainingIngredients.isEmpty();
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

                RecipeIngredient expected = getExpectedIngredientAt(shape, patternX, patternY);

                if (!matchesResource(stack, expected)) {
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

    private boolean matchesResource(ItemStack stack, RecipeIngredient expected) {

        if (expected == null) {
            return stack.isEmpty();
        }

        if (stack.isEmpty()) {
            return false;
        }

        Item expectedItem = ResourceResolver.getItem(expected.getResource());

        return stack.getItem() == expectedItem;
    }

    private RecipeIngredient findMatchingIngredient(ItemStack stack) {

        RecipeShape shape = data.getShape();

        if (!(shape instanceof ShapelessRecipe)) {
            return null;
        }

        ShapelessRecipe shapelessRecipe = (ShapelessRecipe) shape;

        for (RecipeIngredient ingredient : shapelessRecipe.getIngredients()) {

            if (matchesResource(stack, ingredient)) {
                return ingredient;
            }
        }

        return null;
    }

    private RecipeIngredient getExpectedIngredientAt(ShapedRecipe shape, int x, int y) {

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