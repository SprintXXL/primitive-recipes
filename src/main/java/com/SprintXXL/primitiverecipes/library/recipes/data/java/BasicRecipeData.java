package com.SprintXXL.primitiverecipes.library.recipes.data.java;

import com.SprintXXL.primitiverecipes.library.recipes.data.RecipeData;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.RecipeShape;
import com.SprintXXL.primitiverecipes.library.resources.ResourceDefinition;

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
