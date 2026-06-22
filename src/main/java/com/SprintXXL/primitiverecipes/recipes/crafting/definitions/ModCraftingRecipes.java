package com.SprintXXL.primitiverecipes.recipes.crafting.definitions;

import com.SprintXXL.primitiverecipeapi.crafting.CraftingRecipe;
import com.SprintXXL.primitiverecipeapi.crafting.data.BasicRecipeData;
import com.SprintXXL.primitiverecipeapi.crafting.data.ExternalRecipeData;
import com.SprintXXL.primitiverecipeapi.crafting.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipeapi.shared.Category;
import com.SprintXXL.primitiverecipeapi.shared.Owner;
import com.SprintXXL.primitiverecipeapi.shared.RecipeRuntime;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.recipes.RecipePart;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.containers.ContainerStencilTable;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeModularTool;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipePartReplacement;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolModifier;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolRepair;
import com.SprintXXL.primitiveutilitytools.tools.recipes.*;

import java.util.Map;

import static com.SprintXXL.primitiverecipeapi.crafting.CraftingRecipeRegistry.register;
import static com.SprintXXL.primitiverecipeapi.ingredients.RemainingBehavior.DAMAGE;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;
import static com.SprintXXL.primitiverecipeapi.ingredients.RecipeIngredient.*;

public final class ModCraftingRecipes {

    private ModCraftingRecipes() {}

    // Headers

    // ASSEMBLY \\
    // PROCESSING \\
    // CONVERSION \\
    // MIXING \\
    // CUSTOM \\

    // ************ \\
    // UTILITYTOOLS \\
    // ************ \\

    // ASSEMBLY \\
    public static final CraftingRecipe ASSEMBLE_CROWBAR =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_CROWBAR,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeCrowbar.class,
                            RecipeCrowbar::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_FILE =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_FILE,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeFile.class,
                            RecipeFile::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_HAMMER =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_HAMMER,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeHammer.class,
                            RecipeHammer::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_KNIFE =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_KNIFE,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeKnife.class,
                            RecipeKnife::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_MORTAR =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_MORTAR,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeMortar.class,
                            RecipeMortar::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_SAW =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_SAW,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeSaw.class,
                            RecipeSaw::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_SCREWDRIVER =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_SCREWDRIVER,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeScrewdriver.class,
                            RecipeScrewdriver::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_WRENCH =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_WRENCH,
                    Owner.UTILITYTOOLS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeWrench.class,
                            RecipeWrench::new
                    )
            );

    // ********* \\
    // TOOLWORKS \\
    // ********* \\

    // ASSEMBLY \\
    public static final CraftingRecipe ASSEMBLE_MODULAR_TOOL =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_MODULAR_TOOL,
                    Owner.TOOLWORKS,
                    RecipeRuntime.CUSTOM,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeModularTool.class
                    )
            );
    public static final CraftingRecipe ASSEMBLE_MODULAR_PART =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_MODULAR_PART,
                    Owner.TOOLWORKS,
                    RecipeRuntime.CUSTOM,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipePart.class
                    )
            );
    public static final CraftingRecipe ASSEMBLE_BLANK_PATTERN =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_BLANK_PATTERN,
                    Owner.TOOLWORKS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "PP",
                                            "PP"
                                    ),
                                    Map.of(
                                            'P', of(PAPER)
                                    )
                            ),
                            BLANK_PATTERN,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_TOOL_STATION =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_TOOL_STATION,
                    Owner.TOOLWORKS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "PPP",
                                            "BCB",
                                            "PPP"
                                    ),
                                    Map.of(
                                            'P', of(PLANKS, 0),
                                            'B', of(BLANK_PATTERN),
                                            'C', of(CRAFTING_TABLE)
                                    )
                            ),
                            TOOL_STATION,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_PART_BUILDER =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_PART_BUILDER,
                    Owner.TOOLWORKS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "LLL",
                                            "BCB",
                                            "LLL"
                                    ),
                                    Map.of(
                                            'L', of(LOG, 0),
                                            'B', of(BLANK_PATTERN),
                                            'C', of(CRAFTING_TABLE)
                                    )
                            ),
                            PART_BUILDER,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_STENCIL_TABLE =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_STENCIL_TABLE,
                    Owner.TOOLWORKS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "LLL",
                                            "BCB",
                                            "LLL"
                                    ),
                                    Map.of(
                                            'L', of(LOG, 2),
                                            'B', of(BLANK_PATTERN),
                                            'C', of(CRAFTING_TABLE)
                                    )
                            ),
                            STENCIL_TABLE,
                            1
                    )
            );

    // PROCESSING \\
    public static final CraftingRecipe CARVE_PATTERN =
            new CraftingRecipe(
                    ModCRIDs.CARVE_PATTERN,
                    Owner.TOOLWORKS,
                    RecipeRuntime.CUSTOM,
                    Category.PROCESSING,
                    new ExternalRecipeData(
                            ContainerStencilTable.class
                    )
            );

    // CUSTOM \\
    public static final CraftingRecipe REPAIR_MODULAR_TOOL =
            new CraftingRecipe(
                    ModCRIDs.REPAIR_MODULAR_TOOL,
                    Owner.TOOLWORKS,
                    RecipeRuntime.CUSTOM,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeToolRepair.class
                    )
            );
    public static final CraftingRecipe APPLY_MODULAR_TOOL_MODIFIER =
            new CraftingRecipe(
                    ModCRIDs.APPLY_MODULAR_TOOL_MODIFIER,
                    Owner.TOOLWORKS,
                    RecipeRuntime.CUSTOM,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeToolModifier.class
                    )
            );
    public static final CraftingRecipe REPLACE_MODULAR_TOOL_PART =
            new CraftingRecipe(
                    ModCRIDs.REPLACE_MODULAR_TOOL_PART,
                    Owner.TOOLWORKS,
                    RecipeRuntime.CUSTOM,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipePartReplacement.class
                    )
            );
    
    // ********* \\
    // MATERIALS \\
    // ********* \\
    
    // ASSEMBLY \\
    public static final CraftingRecipe ASSEMBLE_IRON_GEAR =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_IRON_GEAR,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "PRP",
                                            "RPR",
                                            "PRP"
                                    ),
                                    Map.of(
                                            'P', of(IRON_PLATE),
                                            'R', of(IRON_ROD)
                                    )
                            ),
                            IRON_GEAR,
                            1
                    )
            );
    public static final CraftingRecipe ASSEMBLE_BRONZE_GEAR =
            new CraftingRecipe(
                    ModCRIDs.ASSEMBLE_BRONZE_GEAR,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "PRP",
                                            "RPR",
                                            "PRP"
                                    ),
                                    Map.of(
                                            'P', of(BRONZE_PLATE),
                                            'R', of(BRONZE_ROD)
                                    )
                            ),
                            BRONZE_GEAR,
                            1
                    )
            );

    // PROCESSING \\
    public static final CraftingRecipe HAMMER_IRON_PLATE =
            new CraftingRecipe(
                    ModCRIDs.HAMMER_IRON_PLATE,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
    public static final CraftingRecipe FILE_IRON_ROD =
            new CraftingRecipe(
                    ModCRIDs.FILE_IRON_ROD,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
    public static final CraftingRecipe SAW_IRON_BOLT =
            new CraftingRecipe(
                    ModCRIDs.SAW_IRON_BOLT,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
    public static final CraftingRecipe FILE_IRON_SCREW =
            new CraftingRecipe(
                    ModCRIDs.FILE_IRON_SCREW,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
    public static final CraftingRecipe MORTAR_IRON_DUST =
            new CraftingRecipe(
                    ModCRIDs.MORTAR_IRON_DUST,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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

    // MIXING \\
    public static final CraftingRecipe MIX_BRONZE_DUST =
            new CraftingRecipe(
                    ModCRIDs.MIX_BRONZE_DUST,
                    Owner.MATERIALS,
                    RecipeRuntime.FORGE,
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

        // ************ \\
        // UTILITYTOOLS \\
        // ************ \\

        // ASSEMBLY \\
        register(ASSEMBLE_CROWBAR);
        register(ASSEMBLE_FILE);
        register(ASSEMBLE_HAMMER);
        register(ASSEMBLE_KNIFE);
        register(ASSEMBLE_MORTAR);
        register(ASSEMBLE_SAW);
        register(ASSEMBLE_SCREWDRIVER);
        register(ASSEMBLE_WRENCH);

        // ********* \\
        // TOOLWORKS \\
        // ********* \\

        // ASSEMBLY \\
        register(ASSEMBLE_MODULAR_TOOL);
        register(ASSEMBLE_MODULAR_PART);
        register(ASSEMBLE_BLANK_PATTERN);
        register(ASSEMBLE_TOOL_STATION);
        register(ASSEMBLE_PART_BUILDER);
        register(ASSEMBLE_STENCIL_TABLE);

        // CUSTOM \\
        register(REPAIR_MODULAR_TOOL);
        register(APPLY_MODULAR_TOOL_MODIFIER);
        register(REPLACE_MODULAR_TOOL_PART);
        register(CARVE_PATTERN);

        // ********* \\
        // MATERIALS \\
        // ********* \\
        
        // ASSEMBLY \\
        register(ASSEMBLE_IRON_GEAR);
        register(ASSEMBLE_BRONZE_GEAR);

        // PROCESSING \\
        register(HAMMER_IRON_PLATE);
        register(HAMMER_BRONZE_PLATE);
        register(FILE_IRON_ROD);
        register(FILE_BRONZE_ROD);
        register(SAW_IRON_BOLT);
        register(SAW_BRONZE_BOLT);
        register(FILE_IRON_SCREW);
        register(FILE_BRONZE_SCREW);
        register(MORTAR_IRON_DUST);
        register(MORTAR_BRONZE_DUST);

        // MIXING \\
        register(MIX_BRONZE_DUST);
    }

    private static String[] Pattern(String... rows) {
        return rows;
    }
}