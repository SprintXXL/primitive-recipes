package com.SprintXXL.primitiverecipes.resources;

public class ResourceDefinition {

    private final String id;
    private final ResourceType type;

    public ResourceDefinition(
            String id,
            ResourceType type
    ) {
        this.id = id;
        this.type = type;
    }

    public String getID() {
        return id;
    }

    public ResourceType getType() {
        return type;
    }
}