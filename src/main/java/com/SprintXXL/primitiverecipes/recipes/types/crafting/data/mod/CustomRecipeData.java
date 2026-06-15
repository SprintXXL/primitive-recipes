package com.SprintXXL.primitiverecipes.recipes.types.crafting.data.mod;

import com.SprintXXL.primitiverecipes.recipes.shared.RecipeOwner;
import com.SprintXXL.primitiverecipes.recipes.shared.RecipeRuntime;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.RecipeData;
import net.minecraft.item.crafting.IRecipe;

import java.util.function.Supplier;

public class CustomRecipeData implements RecipeData {

    private final RecipeRuntime runtime;
    private final Supplier<IRecipe> recipeSupplier;

    public CustomRecipeData(
            RecipeRuntime runtime,
            Supplier<IRecipe> recipeSupplier
    ) {
        this.runtime = runtime;
        this.recipeSupplier = recipeSupplier;
    }

    public RecipeRuntime getRuntime() {
        return runtime;
    }

    public IRecipe createRecipe() {
        return recipeSupplier.get();
    }
}
