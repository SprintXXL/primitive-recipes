package com.SprintXXL.primitiverecipes.recipes.factory;

import com.SprintXXL.primitiverecipeapi.factory.FactoryIDs;
import com.SprintXXL.primitiverecipeapi.factory.FactoryRecipe;
import com.SprintXXL.primitiverecipeapi.factory.MatchingMode;
import com.SprintXXL.primitiverecipeapi.factory.data.BasicFactoryData;

import static com.SprintXXL.primitiverecipeapi.factory.FactoryRecipeRegistry.register;
import static com.SprintXXL.primitiverecipeapi.factory.data.BasicFactoryData.inputs;
import static com.SprintXXL.primitiverecipeapi.factory.data.BasicFactoryData.outputs;
import static com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource.*;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;

public final class ModFactoryRecipes {

    private ModFactoryRecipes() {}

    public static void initModFactoryRecipes() {

        // TEST \\
        register(TEST_RECIPE);

        // FACTORY RECIPES \\
        register(LOG_TO_CHARCOAL);
    }

    // TEST \\
    public static final FactoryRecipe TEST_RECIPE =
            new FactoryRecipe(
                    FactoryRecipeIDs.TEST_RECIPE,
                    FactoryIDs.TEST_FACTORY,
                    MatchingMode.POOLED,
                    new BasicFactoryData(
                            5,
                            inputs(
                                    item(COBBLESTONE).count(2),
                                    item(DIRT).count(3),
                                    item(VANILLA_COAL).count(2).overrideInputSlot(4)
                            ),
                            outputs(
                                    item(STONE).count(4).overrideOutputSlot(3),
                                    item(PLANKS).count(4).meta(2)
                            )
                    )
            );

    // FACTORY RECIPES \\
    public static final FactoryRecipe LOG_TO_CHARCOAL =
            new FactoryRecipe(
                    FactoryRecipeIDs.LOG_TO_CHARCOAL,
                    FactoryIDs.COKE_OVEN,
                    MatchingMode.POSITIONAL,
                    new BasicFactoryData(
                            10,
                            inputs(
                                    tag("logWood")
                            ),
                            outputs(
                                    item(VANILLA_COAL).meta(1)
                            )
                    )
            );
}