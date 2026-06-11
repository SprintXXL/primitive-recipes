package com.SprintXXL.primitiverecipes.library.recipes.data;

import com.SprintXXL.primitiverecipes.library.resources.ResourceDefinition;

public class RecipeIngredient {

    private final ResourceDefinition resource;
    private final RemainingBehavior remainingBehavior;

    public RecipeIngredient(
            ResourceDefinition resource,
            RemainingBehavior remainingBehavior
    ) {
        this.resource = resource;
        this.remainingBehavior = remainingBehavior;
    }

    public ResourceDefinition getResource() {
        return resource;
    }

    public RemainingBehavior getRemainingBehavior() {
        return remainingBehavior;
    }

    public static RecipeIngredient of(ResourceDefinition resource) {
        return new RecipeIngredient(resource, RemainingBehavior.CONSUME);
    }

    public static RecipeIngredient withBehavior(ResourceDefinition resource, RemainingBehavior behavior) {
        return new RecipeIngredient(resource, behavior);
    }
}
