package com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions;

import com.SprintXXL.primitiverecipes.recipes.shared.Category;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.RecipeData;

public class CraftingRecipe {

    private final String id;
    private final Category category;
    private final RecipeData data;

    public CraftingRecipe(
            String id,
            Category category,
            RecipeData data
    ) {
        this.id = id;
        this.category = category;
        this.data = data;
    }

    public String getID() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public RecipeData getData() {
        return data;
    }
}
