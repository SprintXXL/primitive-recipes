package com.SprintXXL.primitiverecipes.util.factories;

import com.SprintXXL.primitiverecipes.library.recipes.RecipeDefinition;
import com.SprintXXL.primitiverecipes.library.recipes.recipes.BasicJavaRecipe;
import net.minecraft.item.crafting.IRecipe;

public final class JavaRecipeFactory {

    private JavaRecipeFactory() {}

    public static IRecipe create(RecipeDefinition definition) {
        return new BasicJavaRecipe(definition);
    }
}
