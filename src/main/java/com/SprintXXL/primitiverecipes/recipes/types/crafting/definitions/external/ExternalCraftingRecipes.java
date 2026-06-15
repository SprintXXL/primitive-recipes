package com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.external;

import com.SprintXXL.primitiverecipes.recipes.shared.Category;
import com.SprintXXL.primitiverecipes.recipes.shared.RecipeOwner;
import com.SprintXXL.primitiverecipes.recipes.shared.RecipeRuntime;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.CraftingRecipe;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.external.ExternalRecipeData;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.recipes.RecipePart;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.containers.ContainerStencilTable;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeModularTool;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipePartReplacement;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolModifier;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolRepair;
import com.SprintXXL.primitiveutilitytools.tools.recipes.*;

import static com.SprintXXL.primitiverecipes.recipes.registry.RecipeRegistry.register;

public final class ExternalCraftingRecipes {

    private ExternalCraftingRecipes() {}

    // ************ \\
    // UTILITYTOOLS \\
    // ************ \\
    public static final CraftingRecipe ASSEMBLE_CROWBAR =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_CROWBAR,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeCrowbar.class,
                            RecipeCrowbar::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_FILE =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_FILE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeFile.class,
                            RecipeFile::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_HAMMER =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_HAMMER,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeHammer.class,
                            RecipeHammer::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_KNIFE =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_KNIFE,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeKnife.class,
                            RecipeKnife::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_MORTAR =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_MORTAR,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeMortar.class,
                            RecipeMortar::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_SAW =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_SAW,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeSaw.class,
                            RecipeSaw::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_SCREWDRIVER =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_SCREWDRIVER,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeScrewdriver.class,
                            RecipeScrewdriver::new
                    )
            );
    public static final CraftingRecipe ASSEMBLE_WRENCH =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_WRENCH,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.UTILITYTOOLS,
                            RecipeRuntime.FORGE,
                            RecipeWrench.class,
                            RecipeWrench::new
                    )
            );

    // ********* \\
    // TOOLWORKS \\
    // ********* \\
    public static final CraftingRecipe ASSEMBLE_MODULAR_TOOL =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_MODULAR_TOOL,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.TOOLWORKS,
                            RecipeRuntime.CUSTOM,
                            RecipeModularTool.class
                    )
            );
    public static final CraftingRecipe REPAIR_MODULAR_TOOL =
            new CraftingRecipe(
                    ExternalCRIDs.REPAIR_MODULAR_TOOL,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.TOOLWORKS,
                            RecipeRuntime.CUSTOM,
                            RecipeToolRepair.class
                    )
            );
    public static final CraftingRecipe APPLY_MODULAR_TOOL_MODIFIER =
            new CraftingRecipe(
                    ExternalCRIDs.APPLY_MODULAR_TOOL_MODIFIER,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.TOOLWORKS,
                            RecipeRuntime.CUSTOM,
                            RecipeToolModifier.class
                    )
            );
    public static final CraftingRecipe REPLACE_MODULAR_TOOL_PART =
            new CraftingRecipe(
                    ExternalCRIDs.REPLACE_MODULAR_TOOL_PART,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.TOOLWORKS,
                            RecipeRuntime.CUSTOM,
                            RecipePartReplacement.class
                    )
            );
    public static final CraftingRecipe ASSEMBLE_MODULAR_PART =
            new CraftingRecipe(
                    ExternalCRIDs.ASSEMBLE_MODULAR_PART,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.TOOLWORKS,
                            RecipeRuntime.CUSTOM,
                            RecipePart.class
                    )
            );
    public static final CraftingRecipe CARVE_PATTERN =
            new CraftingRecipe(
                    ExternalCRIDs.CARVE_PATTERN,
                    Category.ASSEMBLY,
                    new ExternalRecipeData(
                            RecipeOwner.TOOLWORKS,
                            RecipeRuntime.CUSTOM,
                            ContainerStencilTable.class
                    )
            );

    public static void initExternalCraftingRecipes() {

        // ************ \\
        // UTILITYTOOLS \\
        // ************ \\
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
        register(ASSEMBLE_MODULAR_TOOL);
        register(REPAIR_MODULAR_TOOL);
        register(APPLY_MODULAR_TOOL_MODIFIER);
        register(REPLACE_MODULAR_TOOL_PART);
        register(ASSEMBLE_MODULAR_PART);
        register(CARVE_PATTERN);
    }
}