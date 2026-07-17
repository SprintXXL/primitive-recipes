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
import static com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource.*;
import static com.SprintXXL.primitiverecipeapi.resources.recipe.RemainingBehavior.DAMAGE;
import static com.SprintXXL.primitiverecipes.resources.ModResources.*;

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

    // ********* \\
    // TOOLWORKS \\
    // ********* \\

    // ASSEMBLY \\
    
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
                                            'P', item(IRON_PLATE),
                                            'R', item(IRON_ROD)
                                    )
                            ),
                            item(IRON_GEAR)
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
                                            'P', item(BRONZE_PLATE),
                                            'R', item(BRONZE_ROD)
                                    )
                            ),
                            item(BRONZE_GEAR)
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
                                            'H', item(HAMMER).withBehavior(DAMAGE),
                                            'I', item(IRON_INGOT)
                                    )
                            ),
                            item(IRON_PLATE)
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
                                            'H', item(HAMMER).withBehavior(DAMAGE),
                                            'I', item(BRONZE_INGOT)
                                    )
                            ),
                            item(BRONZE_PLATE)
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
                                            'F', item(FILE).withBehavior(DAMAGE),
                                            'I', item(IRON_INGOT)
                                    )
                            ),
                            item(IRON_ROD)
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
                                            'F', item(FILE).withBehavior(DAMAGE),
                                            'I', item(BRONZE_INGOT)
                                    )
                            ),
                            item(BRONZE_ROD)
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
                                            'S', item(SAW).withBehavior(DAMAGE),
                                            'R', item(IRON_ROD)
                                    )
                            ),
                            item(IRON_BOLT).count(2)
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
                                            'S', item(SAW).withBehavior(DAMAGE),
                                            'R', item(BRONZE_ROD)
                                    )
                            ),
                            item(BRONZE_BOLT).count(2)
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
                                            'F', item(FILE).withBehavior(DAMAGE),
                                            'B', item(IRON_BOLT)
                                    )
                            ),
                            item(IRON_SCREW)
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
                                            'F', item(FILE).withBehavior(DAMAGE),
                                            'B', item(BRONZE_BOLT)
                                    )
                            ),
                            item(BRONZE_SCREW)
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
                                            'M', item(MORTAR).withBehavior(DAMAGE),
                                            'I', item(IRON_INGOT)
                                    )
                            ),
                            item(IRON_DUST)
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
                                            'M', item(MORTAR).withBehavior(DAMAGE),
                                            'I', item(BRONZE_INGOT)
                                    )
                            ),
                            item(BRONZE_DUST)
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
                                            'C', item(COPPER_DUST),
                                            'T', item(TIN_DUST)
                                    )
                            ),
                            item(BRONZE_DUST)
                    )
            );
}