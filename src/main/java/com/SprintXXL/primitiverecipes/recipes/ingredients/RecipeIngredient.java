package com.SprintXXL.primitiverecipes.recipes.ingredients;

import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.RemainingBehavior;
import com.SprintXXL.primitiverecipes.resources.ResourceDefinition;

public class RecipeIngredient {

    private final IngredientType type;
    private final ResourceDefinition resource;
    private final String tag;
    private final RemainingBehavior remainingBehavior;

    public RecipeIngredient(
            IngredientType type,
            ResourceDefinition resource,
            String tag,
            RemainingBehavior remainingBehavior
    ) {
        this.type = type;
        this.resource = resource;
        this.tag = tag;
        this.remainingBehavior = remainingBehavior;
    }

    public IngredientType getType() {
        return type;
    }

    public ResourceDefinition getResource() {
        return resource;
    }

    public String getTag() {
        return tag;
    }

    public RemainingBehavior getRemainingBehavior() {
        return remainingBehavior;
    }

    public static RecipeIngredient of(ResourceDefinition resource) {
        return new RecipeIngredient(IngredientType.RESOURCE, resource, null, RemainingBehavior.CONSUME);
    }

    public static RecipeIngredient withBehavior(ResourceDefinition resource, RemainingBehavior behavior) {
        return new RecipeIngredient(IngredientType.RESOURCE, resource, null, behavior);
    }

    public static RecipeIngredient tag(String tag) {
        return new RecipeIngredient(IngredientType.TAG, null, tag, RemainingBehavior.CONSUME);
    }

    public static RecipeIngredient tagWithBehavior(String tag, RemainingBehavior behavior) {
        return new RecipeIngredient(IngredientType.TAG, null, tag, behavior);
    }
}
