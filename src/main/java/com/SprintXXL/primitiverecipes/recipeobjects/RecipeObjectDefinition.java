package com.SprintXXL.primitiverecipes.recipeobjects;

public class RecipeObjectDefinition {

    private final String id;
    private final RecipeObjectType type;

    public RecipeObjectDefinition(
            String id,
            RecipeObjectType type
    ) {
        this.id = id;
        this.type = type;
    }

    public String getID() {
        return id;
    }

    public RecipeObjectType getType() {
        return type;
    }
}
