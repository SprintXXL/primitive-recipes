package com.SprintXXL.primitiverecipes.recipes.factory;

import com.SprintXXL.primitiverecipeapi.factory.FactoryIDs;
import com.SprintXXL.primitiverecipeapi.factory.FactoryRecipe;
import com.SprintXXL.primitiverecipeapi.factory.data.BasicFactoryData;

import static com.SprintXXL.primitiverecipeapi.factory.FactoryRecipeRegistry.register;
import static com.SprintXXL.primitiverecipeapi.ingredients.RecipeIngredient.tag;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;
import static com.SprintXXL.primitiverecipeapi.ingredients.RecipeIngredient.*;

public final class ModFactoryRecipes {

    private ModFactoryRecipes() {}

    public static void initModFactoryRecipes() {

        register(LOG_TO_CHARCOAL);
    }

    public static final FactoryRecipe LOG_TO_CHARCOAL =
            new FactoryRecipe(
                    FactoryRecipeIDs.LOG_TO_CHARCOAL,
                    FactoryIDs.COKE_OVEN,
                    new BasicFactoryData(
                            10,
                            tag("logWood"),
                            of(VANILLA_COAL, 1)
                    )
            );
}
