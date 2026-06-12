package com.SprintXXL.primitiverecipes.recipes.crafting.data.java;

import com.SprintXXL.primitiverecipes.recipes.crafting.data.RecipeData;
import com.SprintXXL.primitiverecipes.recipes.crafting.data.shape.RecipeShape;
import com.SprintXXL.primitiverecipes.resources.ResourceDefinition;

public class BasicRecipeData implements RecipeData {

    private final RecipeShape shape;
    private final ResourceDefinition output;
    private final int count;

    public BasicRecipeData(
            RecipeShape shape,
            ResourceDefinition output,
            int count
    ) {
        this.shape = shape;
        this.output = output;
        this.count = count;
    }

    public RecipeShape getShape() {
        return shape;
    }

    public ResourceDefinition getOutput() {
        return output;
    }

    public int getCount() {
        return count;
    }
}
