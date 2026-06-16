package com.SprintXXL.primitiverecipes.recipes.crafting;

import com.SprintXXL.primitiverecipes.recipes.shared.Category;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.RecipeData;
import com.SprintXXL.primitiverecipes.recipes.shared.Owner;
import com.SprintXXL.primitiverecipes.recipes.shared.Runtime;

public class CraftingRecipe {

    private final String id;
    private final Owner owner;
    private final Runtime runtime;
    private final Category category;
    private final RecipeData data;

    public CraftingRecipe(
            String id,
            Owner owner,
            Runtime runtime,
            Category category,
            RecipeData data
    ) {
        this.id = id;
        this.owner = owner;
        this.runtime = runtime;
        this.category = category;
        this.data = data;
    }

    public String getID() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public Runtime getRuntime() {
        return runtime;
    }

    public Category getCategory() {
        return category;
    }

    public RecipeData getData() {
        return data;
    }
}
