package com.SprintXXL.primitiverecipes.recipes.shape;

import com.SprintXXL.primitiverecipes.recipeobjects.RecipeObjectDefinition;

import java.util.Map;

public class ShapedRecipe implements RecipeShape {

    private final String[] pattern;
    private final Map<Character, RecipeObjectDefinition> keys;

    public ShapedRecipe(
            String[] pattern,
            Map<Character, RecipeObjectDefinition> keys
    ) {
        this.pattern = pattern;
        this.keys = keys;
    }

    public String[] getPattern() {
        return pattern;
    }

    public Map<Character, RecipeObjectDefinition> getKeys() {
        return keys;
    }
}
