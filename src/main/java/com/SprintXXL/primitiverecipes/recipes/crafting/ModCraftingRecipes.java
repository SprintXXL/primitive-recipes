package com.SprintXXL.primitiverecipes.recipes.crafting;

import com.SprintXXL.primitiverecipes.recipes.crafting.data.java.BasicRecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.json.JsonRecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.shape.ShapedRecipe;

import java.util.Map;

import static com.SprintXXL.primitiverecipes.recipes.RecipeRegistry.register;
import static com.SprintXXL.primitiverecipes.recipes.crafting.data.RecipeIngredient.*;
import static com.SprintXXL.primitiverecipes.recipes.crafting.data.RemainingBehavior.*;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;

public final class ModCraftingRecipes {

    private ModCraftingRecipes() {}

    // ******** \\
    // ASSEMBLY \\
    // ******** \\

    //* GEARS *\\
    public static final CraftingRecipe ASSEMBLE_IRON_GEAR =
            new CraftingRecipe(
                    CRIDs.ASSEMBLE_IRON_GEAR,
                    CRCategory.ASSEMBLY,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "RPR",
                                            "PRP",
                                            "RPR"
                                    ),
                                    Map.of(
                                            'R', of(IRON_ROD),
                                            'P', of(IRON_PLATE)
                                    )
                            ),
                            IRON_GEAR,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_BRONZE_GEAR =
            new CraftingRecipe(
                    CRIDs.ASSEMBLE_BRONZE_GEAR,
                    CRCategory.ASSEMBLY,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "RPR",
                                            "PRP",
                                            "RPR"
                                    ),
                                    Map.of(
                                            'R', of(BRONZE_ROD),
                                            'P', of(BRONZE_PLATE)
                                    )
                            ),
                            BRONZE_GEAR,
                            1
                    )
            );

    // ********** \\
    // PROCESSING \\
    // ********** \\

    //* PLATES *\\
    public static final CraftingRecipe HAMMER_IRON_PLATE =
            new CraftingRecipe(
                    CRIDs.HAMMER_IRON_PLATE,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            " H ",
                                            "III",
                                            "III"
                                    ),
                                    Map.of(
                                            'H', withBehavior(HAMMER, DAMAGE),
                                            'I', of(IRON_INGOT)
                                    )
                            ),
                            IRON_PLATE,
                            1
                    )
            );
    public static final CraftingRecipe HAMMER_BRONZE_PLATE =
            new CraftingRecipe(
                    CRIDs.HAMMER_BRONZE_PLATE,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            " H ",
                                            "III",
                                            "III"
                                    ),
                                    Map.of(
                                            'H', withBehavior(HAMMER, DAMAGE),
                                            'I', of(BRONZE_INGOT)
                                    )
                            ),
                            BRONZE_PLATE,
                            1
                    )
            );

    //* ROD *\\
    public static final CraftingRecipe FILE_IRON_ROD =
            new CraftingRecipe(
                    CRIDs.FILE_IRON_ROD,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "F  ",
                                            " I ",
                                            "  I"
                                    ),
                                    Map.of(
                                            'F', withBehavior(FILE, DAMAGE),
                                            'I', of(IRON_INGOT)
                                    )
                            ),
                            IRON_ROD,
                            1
                    )
            );
    public static final CraftingRecipe FILE_BRONZE_ROD =
            new CraftingRecipe(
                    CRIDs.FILE_BRONZE_ROD,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "F  ",
                                            " I ",
                                            "  I"
                                    ),
                                    Map.of(
                                            'F', withBehavior(FILE, DAMAGE),
                                            'I', of(BRONZE_INGOT)
                                    )
                            ),
                            BRONZE_ROD,
                            1
                    )
            );

    //* BOLT *\\
    public static final CraftingRecipe SAW_IRON_BOLT =
            new CraftingRecipe(
                    CRIDs.SAW_IRON_BOLT,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "S ",
                                            " R"
                                    ),
                                    Map.of(
                                            'S', withBehavior(SAW, DAMAGE),
                                            'R', of(IRON_ROD)
                                    )
                            ),
                            IRON_BOLT,
                            2
                    )
            );
    public static final CraftingRecipe SAW_BRONZE_BOLT =
            new CraftingRecipe(
                    CRIDs.SAW_BRONZE_BOLT,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "S ",
                                            " R"
                                    ),
                                    Map.of(
                                            'S', withBehavior(SAW, DAMAGE),
                                            'R', of(BRONZE_ROD)
                                    )
                            ),
                            BRONZE_BOLT,
                            2
                    )
            );

    //* SCREW *\\
    public static final CraftingRecipe FILE_IRON_SCREW =
            new CraftingRecipe(
                    CRIDs.FILE_IRON_SCREW,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "FB",
                                            "B "
                                    ),
                                    Map.of(
                                            'F', withBehavior(FILE, DAMAGE),
                                            'B', of(IRON_BOLT)
                                    )
                            ),
                            IRON_SCREW,
                            1
                    )
            );
    public static final CraftingRecipe FILE_BRONZE_SCREW =
            new CraftingRecipe(
                    CRIDs.FILE_BRONZE_SCREW,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "FB",
                                            "B "
                                    ),
                                    Map.of(
                                            'F', withBehavior(FILE, DAMAGE),
                                            'B', of(BRONZE_BOLT)
                                    )
                            ),
                            BRONZE_SCREW,
                            1
                    )
            );

    //* DUST *\\
    public static final CraftingRecipe MORTAR_IRON_DUST =
            new CraftingRecipe(
                    CRIDs.MORTAR_IRON_DUST,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "M",
                                            "I"
                                    ),
                                    Map.of(
                                            'M', withBehavior(MORTAR, DAMAGE),
                                            'I', of(IRON_INGOT)
                                    )
                            ),
                            IRON_DUST,
                            1
                    )
            );
    public static final CraftingRecipe MORTAR_BRONZE_DUST =
            new CraftingRecipe(
                    CRIDs.MORTAR_BRONZE_DUST,
                    CRCategory.PROCESSING,
                    CRType.JAVA,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "M",
                                            "I"
                                    ),
                                    Map.of(
                                            'M', withBehavior(MORTAR, DAMAGE),
                                            'I', of(BRONZE_INGOT)
                                    )
                            ),
                            BRONZE_DUST,
                            1
                    )
            );

    // ********** \\
    // CONVERSION \\
    // ********** \\



    // ****** \\
    // MIXING \\
    // ****** \\

    //* MATERIALS *\\
    public static final CraftingRecipe MIX_BRONZE_DUST =
            new CraftingRecipe(
                    CRIDs.MIX_BRONZE_DUST,
                    CRCategory.MIXING,
                    CRType.JSON,
                    new JsonRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "CT",
                                            "CC"
                                    ),
                                    Map.of(
                                            'C', of(COPPER_DUST),
                                            'T', of(TIN_DUST)
                                    )
                            ),
                            BRONZE_DUST,
                            1
                    )
            );

    public static void initModCraftingRecipes() {

        // ******** \\
        // ASSEMBLY \\
        // ******** \\
        register(ASSEMBLE_IRON_GEAR);
        register(ASSEMBLE_BRONZE_GEAR);

        // ********** \\
        // PROCESSING \\
        // ********** \\

        //* PLATES *\\
        register(HAMMER_IRON_PLATE);
        register(HAMMER_BRONZE_PLATE);

        //* ROD *\\
        register(FILE_IRON_ROD);
        register(FILE_BRONZE_ROD);

        //* BOLT *\\
        register(SAW_IRON_BOLT);
        register(SAW_BRONZE_BOLT);

        //* SCREW *\\
        register(FILE_IRON_SCREW);
        register(FILE_BRONZE_SCREW);

        //* DUST *\\
        register(MORTAR_IRON_DUST);
        register(MORTAR_BRONZE_DUST);

        // ********** \\
        // CONVERSION \\
        // ********** \\

        // ****** \\
        // MIXING \\
        // ****** \\

        //* MATERIALS *\\
        register(MIX_BRONZE_DUST);
    }

    private static String[] Pattern(String... rows) {
        return rows;
    }
}
