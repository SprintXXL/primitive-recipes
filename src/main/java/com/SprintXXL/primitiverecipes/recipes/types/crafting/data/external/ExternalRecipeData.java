package com.SprintXXL.primitiverecipes.recipes.types.crafting.data.external;

import com.SprintXXL.primitiverecipes.recipes.shared.RecipeOwner;
import com.SprintXXL.primitiverecipes.recipes.shared.RecipeRuntime;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.RecipeData;
import net.minecraft.item.crafting.IRecipe;

import java.util.function.Supplier;

public class ExternalRecipeData implements RecipeData {

    private final RecipeOwner owner;
    private final RecipeRuntime runtime;
    private final Class<?> recipeClass;
    private final Supplier<IRecipe> recipeSupplier;

    public ExternalRecipeData(
            RecipeOwner owner,
            RecipeRuntime runtime,
            Class<?> recipeClass,
            Supplier<IRecipe> recipeSupplier
    ) {
        this.owner = owner;
        this.runtime = runtime;
        this.recipeClass = recipeClass;
        this.recipeSupplier = recipeSupplier;
    }

    public ExternalRecipeData(
            RecipeOwner owner,
            RecipeRuntime runtime,
            Class<?> recipeClass
    ) {
        this.owner = owner;
        this.runtime = runtime;
        this.recipeClass = recipeClass;
        this.recipeSupplier = null;
    }

    public RecipeOwner getOwner() {
        return owner;
    }

    public RecipeRuntime getRuntime() {
        return runtime;
    }

    public Class<?> getRecipeClass() {
        return recipeClass;
    }

    public IRecipe createRecipe() {
        return recipeSupplier.get();
    }
}
