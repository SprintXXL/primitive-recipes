package com.SprintXXL.resourcegenerator;

public class ResourceTypeResolver {

    public static String getResourceType(String modid) {

        if (modid.equals("minecraft")) {
            return "VANILLA";
        }

        if (modid.equals("primitivematerials")) {
            return "MATERIALS";
        }

        if (modid.equals("primitiveores")) {
            return "ORES";
        }

        if (modid.equals("primitivetools")) {
            return "TOOLS";
        }

        if (modid.equals("primitiveutilitytools")) {
            return "UTILITYTOOLS";
        }

        if (modid.equals("primitivetoolworks")) {
            return "TOOLWORKS";
        }

        return null;
    }
}
