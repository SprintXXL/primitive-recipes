package com.SprintXXL.primitiverecipes.recipeobjects;

public final class ModRecipeObjects {

    private ModRecipeObjects() {}

    public static final RecipeObjectDefinition DIRT =
            new RecipeObjectDefinition(
                    RecipeObjectIDs.DIRT,
                    RecipeObjectType.VANILLA
            );

    public static final RecipeObjectDefinition GRAVEL =
            new RecipeObjectDefinition(
                    RecipeObjectIDs.GRAVEL,
                    RecipeObjectType.VANILLA
            );
}
