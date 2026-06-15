package com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.mod;

import com.SprintXXL.primitiverecipes.recipes.shared.Category;
import com.SprintXXL.primitiverecipes.recipes.shared.RecipeOwner;
import com.SprintXXL.primitiverecipes.recipes.shared.RecipeRuntime;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.mod.CustomRecipeData;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.CraftingRecipe;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.mod.BasicRecipeData;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.external.ExternalRecipeData;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.recipes.custom.LogToPlanksRecipe;

import java.util.Map;

import static com.SprintXXL.primitiverecipes.recipes.registry.RecipeRegistry.register;
import static com.SprintXXL.primitiverecipes.recipes.ingredients.RecipeIngredient.*;
import static com.SprintXXL.primitiverecipes.recipes.types.crafting.data.RemainingBehavior.*;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;

public final class ModCraftingRecipes {

    private ModCraftingRecipes() {}

    // ******** \\
    // ASSEMBLY \\
    // ******** \\

    //* MISC *\\

    public static final CraftingRecipe ASSEMBLE_CRAFTING_TABLE =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_CRAFTING_TABLE,
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
                    ModCRIDs.ASSEMBLE_CHEST,
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
                    ModCRIDs.ASSEMBLE_FURNACE,
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
                    ModCRIDs.ASSEMBLE_HOPPER,
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
                    ModCRIDs.ASSEMBLE_BUCKET,
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

    //* GEARS *\\
    public static final CraftingRecipe ASSEMBLE_IRON_GEAR =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_IRON_GEAR,
                    Category.ASSEMBLY,
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
                    ModCRIDs.ASSEMBLE_BRONZE_GEAR,
                    Category.ASSEMBLY,
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

    //* MISC *\\
    public static final CraftingRecipe CRAFT_FLINT =
            new CraftingRecipe(
                    ModCRIDs.CRAFT_FLINT,
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
                    ModCRIDs.CRAFT_PLANKS,
                    Category.PROCESSING,
                    new CustomRecipeData(
                            RecipeRuntime.FORGE,
                            LogToPlanksRecipe::new
                    )
            );
    public static final CraftingRecipe CRAFT_STICKS =
            new CraftingRecipe(
                    ModCRIDs.CRAFT_STICKS,
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

    //* PLATES *\\
    public static final CraftingRecipe HAMMER_IRON_PLATE =
            new CraftingRecipe(
                    ModCRIDs.HAMMER_IRON_PLATE,
                    Category.PROCESSING,
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
                    ModCRIDs.HAMMER_BRONZE_PLATE,
                    Category.PROCESSING,
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
                    ModCRIDs.FILE_IRON_ROD,
                    Category.PROCESSING,
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
                    ModCRIDs.FILE_BRONZE_ROD,
                    Category.PROCESSING,
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
                    ModCRIDs.SAW_IRON_BOLT,
                    Category.PROCESSING,
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
                    ModCRIDs.SAW_BRONZE_BOLT,
                    Category.PROCESSING,
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
                    ModCRIDs.FILE_IRON_SCREW,
                    Category.PROCESSING,
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
                    ModCRIDs.FILE_BRONZE_SCREW,
                    Category.PROCESSING,
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
                    ModCRIDs.MORTAR_IRON_DUST,
                    Category.PROCESSING,
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
                    ModCRIDs.MORTAR_BRONZE_DUST,
                    Category.PROCESSING,
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
                    ModCRIDs.MIX_BRONZE_DUST,
                    Category.MIXING,
                    new BasicRecipeData(
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

        //* MISC *\\
        register(ASSEMBLE_CRAFTING_TABLE);
        register(ASSEMBLE_CHEST);
        register(ASSEMBLE_FURNACE);
        register(ASSEMBLE_HOPPER);
        register(ASSEMBLE_BUCKET);

        //* GEARS *\\
        register(ASSEMBLE_IRON_GEAR);
        register(ASSEMBLE_BRONZE_GEAR);

        // ********** \\
        // PROCESSING \\
        // ********** \\

        //* MISC *\\
        register(CRAFT_FLINT);
        register(CRAFT_PLANKS);
        register(CRAFT_STICKS);

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
