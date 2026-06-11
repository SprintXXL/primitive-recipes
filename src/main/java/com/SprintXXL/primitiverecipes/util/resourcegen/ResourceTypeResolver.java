package com.SprintXXL.primitiverecipes.util.resourcegen;

import com.SprintXXL.primitiverecipes.library.resources.ResourceType;

public class ResourceTypeResolver {

    public static ResourceType getResourceType(String modid) {

        if (modid.equals("minecraft")) {
            return ResourceType.VANILLA;
        }

        if (modid.equals("primitivematerials")) {
            return ResourceType.MATERIALS;
        }

        if (modid.equals("primitiveores")) {
            return ResourceType.ORES;
        }

        if (modid.equals("primitivetools")) {
            return ResourceType.TOOLS;
        }

        if (modid.equals("primitiveutilitytools")) {
            return ResourceType.UTILITYTOOLS;
        }

        return null;
    }
}
