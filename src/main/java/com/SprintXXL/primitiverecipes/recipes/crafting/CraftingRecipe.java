package com.SprintXXL.primitiverecipes.recipes.crafting;

import com.SprintXXL.primitiverecipes.recipes.crafting.data.RecipeData;

public class CraftingRecipe {

    private final String id;
    private final CRCategory category;
    private final CRType type;
    private final RecipeData data;

    public CraftingRecipe(
            String id,
            CRCategory category,
            CRType type,
            RecipeData data
    ) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.data = data;
    }

    public String getID() {
        return id;
    }

    public CRCategory getCategory() {
        return category;
    }

    public CRType getType() {
        return type;
    }

    public RecipeData getData() {
        return data;
    }
}
