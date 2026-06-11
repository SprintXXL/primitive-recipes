package com.SprintXXL.primitiverecipes.library.recipes.data.shape;

import com.SprintXXL.primitiverecipes.library.recipes.data.RecipeIngredient;

import java.util.List;

public class ShapelessRecipe implements RecipeShape {

    private final List<RecipeIngredient> ingredients;

    public ShapelessRecipe(
            List<RecipeIngredient> ingredients
    ) {
        this.ingredients = ingredients;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }
}
