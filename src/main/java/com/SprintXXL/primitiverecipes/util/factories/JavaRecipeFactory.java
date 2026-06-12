package com.SprintXXL.primitiverecipes.util.factories;

import com.SprintXXL.primitiverecipes.recipes.crafting.CraftingRecipe;
import com.SprintXXL.primitiverecipes.recipes.crafting.recipes.BasicJavaRecipe;
import net.minecraft.item.crafting.IRecipe;

public final class JavaRecipeFactory {

    private JavaRecipeFactory() {}

    public static IRecipe create(CraftingRecipe definition) {
        return new BasicJavaRecipe(definition);
    }
}
