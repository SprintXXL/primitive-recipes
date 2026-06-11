package com.SprintXXL.primitiverecipes.library.recipes.data.json;

import com.SprintXXL.primitiverecipes.library.recipes.data.RecipeData;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.RecipeShape;
import com.SprintXXL.primitiverecipes.library.resources.ResourceDefinition;

public class JsonRecipeData implements RecipeData {

    private final RecipeShape shape;
    private final ResourceDefinition output;
    private final int count;

    public JsonRecipeData(
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
