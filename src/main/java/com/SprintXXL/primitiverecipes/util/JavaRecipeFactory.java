package com.SprintXXL.primitiverecipes.util;

import com.SprintXXL.primitiverecipes.recipes.crafting.data.CustomRecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.CraftingRecipe;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.BasicRecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.ExternalRecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.recipes.generic.BasicJavaRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

import static com.SprintXXL.primitiverecipes.Reference.MODID;

public final class JavaRecipeFactory {

    private JavaRecipeFactory() {}

    public static IRecipe create(CraftingRecipe definition) {

        if (definition.getData() instanceof BasicRecipeData) {
            return new BasicJavaRecipe(definition);
        }

        if (definition.getData() instanceof CustomRecipeData) {

            CustomRecipeData data = (CustomRecipeData) definition.getData();
            IRecipe recipe = data.createRecipe();

            recipe.setRegistryName(new ResourceLocation(MODID, definition.getID()));

            return recipe;
        }

        if (definition.getData() instanceof ExternalRecipeData) {

            ExternalRecipeData data = (ExternalRecipeData) definition.getData();
            IRecipe recipe = data.createRecipe();

            recipe.setRegistryName(new ResourceLocation(MODID, definition.getID()));

            return recipe;
        }

        throw new IllegalArgumentException("Unsupported recipe data: " + definition.getData().getClass().getName());
    }
}
