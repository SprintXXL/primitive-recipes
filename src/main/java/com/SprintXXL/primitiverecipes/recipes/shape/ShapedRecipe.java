package com.SprintXXL.primitiverecipes.recipes.shape;

import com.SprintXXL.primitiverecipes.resources.ResourceDefinition;

import java.util.Map;

public class ShapedRecipe implements RecipeShape {

    private final String[] pattern;
    private final Map<Character, ResourceDefinition> keys;

    public ShapedRecipe(
            String[] pattern,
            Map<Character, ResourceDefinition> keys
    ) {
        this.pattern = pattern;
        this.keys = keys;
    }

    public String[] getPattern() {
        return pattern;
    }

    public Map<Character, ResourceDefinition> getKeys() {
        return keys;
    }
}
