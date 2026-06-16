package com.SprintXXL.primitiverecipes.recipes.crafting.shape;

import com.SprintXXL.primitiverecipes.recipes.ingredients.RecipeIngredient;

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
