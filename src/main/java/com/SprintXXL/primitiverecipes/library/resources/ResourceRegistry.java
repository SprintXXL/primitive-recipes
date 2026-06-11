package com.SprintXXL.primitiverecipes.library.resources;

import java.util.*;

public final class ResourceRegistry {

    private ResourceRegistry() {}

    private static final Map<String, ResourceDefinition> RESOURCES =
            new HashMap<>();

    private static final List<ResourceDefinition> ALL_RESOURCES =
            new ArrayList<>();

    public static List<ResourceDefinition> getAllResources() {
        return Collections.unmodifiableList(ALL_RESOURCES);
    }

    public static ResourceDefinition getResource(String id) {
        return RESOURCES.get(id);
    }

    public static void register(ResourceDefinition resource) {
        RESOURCES.put(resource.getID(), resource);
        ALL_RESOURCES.add(resource);
    }

    public static void init() {

        ModResources.initModResources();
    }
}
