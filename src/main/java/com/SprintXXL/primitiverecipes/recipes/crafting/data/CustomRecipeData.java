package com.SprintXXL.primitiverecipes.recipes.crafting.data;

import net.minecraft.item.crafting.IRecipe;

import java.util.function.Supplier;

public class CustomRecipeData implements RecipeData {

    private final Supplier<IRecipe> recipeSupplier;

    public CustomRecipeData(
            Supplier<IRecipe> recipeSupplier
    ) {
        this.recipeSupplier = recipeSupplier;
    }

    public IRecipe createRecipe() {
        return recipeSupplier.get();
    }
}
