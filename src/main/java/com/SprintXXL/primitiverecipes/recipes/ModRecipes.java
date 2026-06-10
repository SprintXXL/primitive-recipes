package com.SprintXXL.primitiverecipes.recipes;

import com.SprintXXL.primitiverecipes.recipes.shape.ShapelessRecipe;
import com.SprintXXL.primitiverecipes.resources.ModResources;

import java.util.List;

import static com.SprintXXL.primitiverecipes.recipes.RecipeRegistry.register;

public final class ModRecipes {

    private ModRecipes() {}

    public static final RecipeDefinition GOLD_NUGGET =
            new RecipeDefinition(
                    RecipeIDs.GOLD_NUGGET,
                    new ShapelessRecipe(
                            List.of(
                                    ModResources.GOLD_INGOT
                            )
                    ),
                    ModResources.GOLD_NUGGET,
                    9
            );

    public static final RecipeDefinition IRON_NUGGET =
            new RecipeDefinition(
                    RecipeIDs.IRON_NUGGET,
                    new ShapelessRecipe(
                            List.of(
                                    ModResources.IRON_INGOT
                            )
                    ),
                    ModResources.IRON_NUGGET,
                    9
            );

    public static final RecipeDefinition COPPER_NUGGET =
            new RecipeDefinition(
                    RecipeIDs.COPPER_NUGGET,
                    new ShapelessRecipe(
                            List.of(
                                    ModResources.COPPER_INGOT
                            )
                    ),
                    ModResources.COPPER_NUGGET,
                    9
            );

    public static final RecipeDefinition TIN_NUGGET =
            new RecipeDefinition(
                    RecipeIDs.TIN_NUGGET,
                    new ShapelessRecipe(
                            List.of(
                                    ModResources.TIN_INGOT
                            )
                    ),
                    ModResources.TIN_NUGGET,
                    9
            );

    public static final RecipeDefinition BRONZE_NUGGET =
            new RecipeDefinition(
                    RecipeIDs.BRONZE_NUGGET,
                    new ShapelessRecipe(
                            List.of(
                                    ModResources.BRONZE_INGOT
                            )
                    ),
                    ModResources.BRONZE_NUGGET,
                    9
            );

    public static void initModRecipes() {

        register(GOLD_NUGGET);
        register(IRON_NUGGET);
        register(COPPER_NUGGET);
        register(TIN_NUGGET);
        register(BRONZE_NUGGET);
    }
}
