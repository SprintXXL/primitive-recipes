package com.SprintXXL.primitiverecipes.recipes.factory;

import com.SprintXXL.primitiverecipeapi.factory.FactoryIDs;
import com.SprintXXL.primitiverecipeapi.factory.FactoryRecipe;
import com.SprintXXL.primitiverecipeapi.factory.MatchingMode;
import com.SprintXXL.primitiverecipeapi.factory.data.BasicFactoryData;

import java.util.List;

import static com.SprintXXL.primitiverecipeapi.factory.FactoryRecipeRegistry.register;
import static com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource.itemMeta;
import static com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource.tag;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;

public final class ModFactoryRecipes {

    private ModFactoryRecipes() {}

    public static void initModFactoryRecipes() {

        register(LOG_TO_CHARCOAL);
    }

    public static final FactoryRecipe LOG_TO_CHARCOAL =
            new FactoryRecipe(
                    FactoryRecipeIDs.LOG_TO_CHARCOAL,
                    FactoryIDs.COKE_OVEN,
                    MatchingMode.POSITIONAL,
                    new BasicFactoryData(
                            10,
                            List.of(
                                    tag("logWood")
                            ),
                            List.of(
                                    itemMeta(VANILLA_COAL, 1)
                            )
                    )
            );
}
