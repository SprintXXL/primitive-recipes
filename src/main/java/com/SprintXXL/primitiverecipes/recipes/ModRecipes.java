package com.SprintXXL.primitiverecipes.recipes;

import com.SprintXXL.primitiverecipes.recipeobjects.ModRecipeObjects;
import com.SprintXXL.primitiverecipes.recipes.shape.ShapelessRecipe;

import java.util.List;

public final class ModRecipes {

    private ModRecipes() {}

    public static final RecipeDefinition TEST =
            new RecipeDefinition(
                    RecipeIDs.TEST,
                    new ShapelessRecipe(
                            List.of(
                                    ModRecipeObjects.DIRT
                            )
                    ),
                    ModRecipeObjects.GRAVEL,
                    1
            );
}
