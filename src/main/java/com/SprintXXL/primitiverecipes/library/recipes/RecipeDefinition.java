package com.SprintXXL.primitiverecipes.library.recipes;

import com.SprintXXL.primitiverecipes.library.recipes.data.RecipeData;

public class RecipeDefinition {

    private final String id;
    private final RecipeType type;
    private final RecipeData data;

    public RecipeDefinition(
            String id,
            RecipeType type,
            RecipeData data
    ) {
        this.id = id;
        this.type = type;
        this.data = data;
    }

    public String getID() {
        return id;
    }

    public RecipeType getType() {
        return type;
    }

    public RecipeData getData() {
        return data;
    }
}
