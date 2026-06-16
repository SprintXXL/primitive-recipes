package com.SprintXXL.primitiverecipes.recipes.crafting.definitions;

import com.SprintXXL.primitiverecipes.recipes.shared.Category;
import com.SprintXXL.primitiverecipes.recipes.shared.Owner;
import com.SprintXXL.primitiverecipes.recipes.shared.Runtime;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.CustomRecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.CraftingRecipe;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.BasicRecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipes.recipes.crafting.recipes.custom.LogToPlanksRecipe;

import java.util.Map;

import static com.SprintXXL.primitiverecipes.recipes.registry.RecipeRegistry.register;
import static com.SprintXXL.primitiverecipes.recipes.ingredients.RecipeIngredient.*;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;

public final class CoreCraftingRecipes {

    private CoreCraftingRecipes() {}

    // ******** \\
    // ASSEMBLY \\
    // ******** \\
    public static final CraftingRecipe ASSEMBLE_CRAFTING_TABLE =
            new CraftingRecipe(
                    CoreCRIDs.ASSEMBLE_CRAFTING_TABLE,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "FF",
                                            "LL"
                                    ),
                                    Map.of(
                                            'F', of(FLINT),
                                            'L', tag("logWood")
                                    )
                            ),
                            CRAFTING_TABLE,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_CHEST =
            new CraftingRecipe(
                    CoreCRIDs.ASSEMBLE_CHEST,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "LPL",
                                            "PFP",
                                            "LPL"
                                    ),
                                    Map.of(
                                            'L', tag("logWood"),
                                            'P', tag("plankWood"),
                                            'F', of(FLINT)
                                    )
                            ),
                            CHEST,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_FURNACE =
            new CraftingRecipe(
                    CoreCRIDs.ASSEMBLE_FURNACE,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "CFC",
                                            "F F",
                                            "CFC"
                                    ),
                                    Map.of(
                                            'C', of(COBBLESTONE),
                                            'F', of(FLINT)
                                    )
                            ),
                            FURNACE,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_HOPPER =
            new CraftingRecipe(
                    CoreCRIDs.ASSEMBLE_HOPPER,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "P P",
                                            "PCP",
                                            " P "
                                    ),
                                    Map.of(
                                            'P', of(IRON_PLATE),
                                            'C', of(CHEST)
                                    )
                            ),
                            HOPPER,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_BUCKET =
            new CraftingRecipe(
                    CoreCRIDs.ASSEMBLE_BUCKET,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "P P",
                                            " P "
                                    ),
                                    Map.of(
                                            'P', of(IRON_PLATE)
                                    )
                            ),
                            BUCKET,
                            1
                    )
            );

    // ********** \\
    // PROCESSING \\
    // ********** \\
    public static final CraftingRecipe CRAFT_FLINT =
            new CraftingRecipe(
                    CoreCRIDs.CRAFT_FLINT,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.PROCESSING,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "G",
                                            "GG"
                                    ),
                                    Map.of(
                                            'G', of(GRAVEL)
                                    )
                            ),
                            FLINT,
                            1
                    )
            );
    public static final CraftingRecipe CRAFT_PLANKS =
            new CraftingRecipe(
                    CoreCRIDs.CRAFT_PLANKS,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.PROCESSING,
                    new CustomRecipeData(
                            LogToPlanksRecipe::new
                    )
            );
    public static final CraftingRecipe CRAFT_STICKS =
            new CraftingRecipe(
                    CoreCRIDs.CRAFT_STICKS,
                    Owner.CORE,
                    Runtime.FORGE,
                    Category.PROCESSING,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "P",
                                            "P"
                                    ),
                                    Map.of(
                                            'P', tag("plankWood")
                                    )
                            ),
                            STICK,
                            1
                    )
            );

    public static void initCoreCraftingRecipes() {

        // ******** \\
        // ASSEMBLY \\
        // ******** \\
        register(ASSEMBLE_CRAFTING_TABLE);
        register(ASSEMBLE_CHEST);
        register(ASSEMBLE_FURNACE);
        register(ASSEMBLE_HOPPER);
        register(ASSEMBLE_BUCKET);

        // ********** \\
        // PROCESSING \\
        // ********** \\
        register(CRAFT_FLINT);
        register(CRAFT_PLANKS);
        register(CRAFT_STICKS);

        // ********** \\
        // CONVERSION \\
        // ********** \\

        // ****** \\
        // MIXING \\
        // ****** \\
    }

    private static String[] Pattern(String... rows) {
        return rows;
    }
}
