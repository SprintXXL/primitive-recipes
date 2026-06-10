package com.SprintXXL.primitiverecipes.recipes;

import com.SprintXXL.primitiverecipes.resources.ResourceDefinition;
import com.SprintXXL.primitiverecipes.recipes.shape.RecipeShape;

public class RecipeDefinition {

    private final String id;
    private final RecipeShape shape;
    private final ResourceDefinition output;
    private final int count;

    public RecipeDefinition(
            String id,
            RecipeShape shape,
            ResourceDefinition output,
            int count
    ) {
        this.id = id;
        this.shape = shape;
        this.output = output;
        this.count = count;
    }

    public String getID() {
        return id;
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
