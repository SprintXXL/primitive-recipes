package com.SprintXXL.primitiverecipes.recipes.shape;

import com.SprintXXL.primitiverecipes.recipeobjects.RecipeObjectDefinition;

import java.util.List;

public class ShapelessRecipe implements RecipeShape {

    private final List<RecipeObjectDefinition> ingredients;

    public ShapelessRecipe(
            List<RecipeObjectDefinition> ingredients
    ) {
        this.ingredients = ingredients;
    }

    public List<RecipeObjectDefinition> getIngredients() {
        return ingredients;
    }
}
