package com.SprintXXL.primitiverecipes.library.recipes;

import com.SprintXXL.primitiverecipes.library.recipes.data.java.BasicRecipeData;
import com.SprintXXL.primitiverecipes.library.recipes.data.json.JsonRecipeData;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.ShapelessRecipe;

import java.util.List;
import java.util.Map;

import static com.SprintXXL.primitiverecipes.library.recipes.RecipeRegistry.register;
import static com.SprintXXL.primitiverecipes.library.recipes.data.RecipeIngredient.*;
import static com.SprintXXL.primitiverecipes.library.recipes.data.RemainingBehavior.*;
import static com.SprintXXL.primitiverecipes.library.resources.ModResources.*;

public final class ModRecipes {

    private ModRecipes() {}

    // JSON RECIPES \\
    public static final RecipeDefinition JSON_BRONZE_DUST =
            new RecipeDefinition(
                    RecipeIDs.BRONZE_DUST,
                    RecipeType.JSON,
                    new JsonRecipeData(
                            new ShapedRecipe(
                                    new String[]{
                                            "CT",
                                            "CC"
                                    },
                                    Map.of(
                                            'C', of(COPPER_DUST),
                                            'T', of(TIN_DUST)
                                    )
                            ),
                            BRONZE_DUST,
                            3
                    )
            );

    // JAVA RECIPES \\
    public static final RecipeDefinition HAMMER_IRON_PLATE =
            new RecipeDefinition(
                    RecipeIDs.IRON_PLATE,
                    RecipeType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    new String[]{
                                            "H",
                                            "I",
                                            "I"
                                    },
                                    Map.of(
                                            'H', withBehavior(HAMMER, DAMAGE),
                                            'I', of(IRON_INGOT)
                                    )
                            ),
                            IRON_PLATE,
                            1
                    )
            );

    public static void initModRecipes() {

        register(JSON_BRONZE_DUST);
        register(HAMMER_IRON_PLATE);
    }
}
