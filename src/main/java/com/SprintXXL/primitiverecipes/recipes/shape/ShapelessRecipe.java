package com.SprintXXL.primitiverecipes.recipes.shape;

import com.SprintXXL.primitiverecipes.resources.ResourceDefinition;

import java.util.List;

public class ShapelessRecipe implements RecipeShape {

    private final List<ResourceDefinition> ingredients;

    public ShapelessRecipe(
            List<ResourceDefinition> ingredients
    ) {
        this.ingredients = ingredients;
    }

    public List<ResourceDefinition> getIngredients() {
        return ingredients;
    }
}
