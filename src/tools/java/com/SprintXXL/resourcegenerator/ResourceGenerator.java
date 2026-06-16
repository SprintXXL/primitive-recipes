package com.SprintXXL.resourcegenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.SprintXXL.resourcegenerator.ResourceTypeResolver.getResourceType;

public class ResourceGenerator {

    private static final String DUMPS_FOLDER = "D:\\Work\\My Modpack\\Mods\\Primitive Recipes\\src\\tools\\java\\com\\SprintXXL\\resourcegenerator\\dumps";
    private static final String OUTPUT_FOLDER = "D:\\Work\\My Modpack\\Mods\\Primitive Recipes\\src\\main\\java\\com\\SprintXXL\\primitiverecipes\\resources";

    static void main() throws IOException {

        generateAllDumpFiles();
    }

    private static void generateAllDumpFiles() throws IOException {

        StringBuilder ids = new StringBuilder();
        StringBuilder definitions = new StringBuilder();
        StringBuilder registers = new StringBuilder();

        Path dumpsFolder = Paths.get(DUMPS_FOLDER);

        Map<String, String> chosenResources = new HashMap<>();

        for (Path dumpFile : Files.list(dumpsFolder).toList()) {

            if (!dumpFile.toString().endsWith(".txt")) {
                continue;
            }

            collectResources(dumpFile, chosenResources);
        }

        for (String registryName : chosenResources.values()) {

            String modid = getModid(registryName);

            ids.append(buildIDLine(registryName)).append("\n");
            definitions.append(buildDefinitionLine(registryName, modid)).append("\n");
            registers.append(buildRegisterLine(registryName)).append("\n");
        }

        String resourceIDsFile = buildResourceIDsFile(ids.toString());
        String modResourcesFile = buildModResourcesFile(definitions.toString(), registers.toString());

        Files.createDirectories(Paths.get(OUTPUT_FOLDER));

        Files.write(
                Paths.get(OUTPUT_FOLDER, "ResourceIDs.java"),
                resourceIDsFile.getBytes()
        );

        Files.write(
                Paths.get(OUTPUT_FOLDER, "ModResources.java"),
                modResourcesFile.getBytes()
        );
    }

    private static String buildResourceIDsFile(String body) {
        return "package com.SprintXXL.primitiverecipes.resources;\n\n" +
                "public final class ResourceIDs {\n\n" +
                "    private ResourceIDs() {}\n\n" +
                body +
                "\n}";
    }

    private static String buildModResourcesFile(String definitions, String registers) {
        return "package com.SprintXXL.primitiverecipes.resources;\n\n" +
                "import static com.SprintXXL.primitiverecipes.resources.ResourceRegistry.register;\n\n" +
                "public final class ModResources {\n\n" +
                "    private ModResources() {}\n\n" +
                definitions +
                "\n" +
                "    public static void initModResources() {\n\n" +
                registers +
                "    }\n\n" +
                "}";
    }

    private static String buildIDLine(String registryName) {

        String line = "    public static final String " + getConstantName(registryName) + " = \"" + registryName + "\"" + ";";

        return line;
    }

    private static String buildDefinitionLine(String registryName, String modid) {

        List<String> lines = new ArrayList<>();

        lines.add("    public static final ResourceDefinition " + getConstantName(registryName) + " =");
        lines.add("            new ResourceDefinition(");
        lines.add("                    ResourceIDs." + getConstantName(registryName) + ",");
        lines.add("                    ResourceType." + getResourceType(modid));
        lines.add("            );");

        return String.join("\n", lines);
    }

    private static String buildRegisterLine(String registryName) {

        String line = "        register(" + getConstantName(registryName) + ");";

        return line;
    }

    private static String getConstantName(String registryName) {

        String[] path = registryName.split(":");

        if (path.length != 2) {
            return null;
        }

        return path[1].toUpperCase();
    }

    private static void collectResources(Path dumpFile, Map<String, String> chosenResources) throws IOException {

        List<String> registryNames = Files.readAllLines(dumpFile);

        for (String registryName : registryNames) {

            if (registryName.trim().isEmpty()) {
                continue;
            }

            String path = getPath(registryName);
            String existing = chosenResources.get(path);

            if (existing == null || hasHigherPriority(registryName, existing)) {
                chosenResources.put(path, registryName);
            }
        }
    }

    private static boolean hasHigherPriority(String candidate, String existing) {
        return getPriority(getModid(candidate)) > getPriority(getModid(existing));
    }

    private static int getPriority(String modid) {

        if (modid.equals("minecraft")) {
            return 0;
        }

        if (modid.equals("primitivematerials")) {
            return 1;
        }

        if (modid.equals("primitiveores")) {
            return 2;
        }

        if (modid.equals("primitivetools")) {
            return 3;
        }

        if (modid.equals("primitiveutilitytools")) {
            return 4;
        }

        if (modid.equals("primitivetoolworks")) {
            return 5;
        }

        return 0;
    }

    private static String getModid(String registryName) {
        return registryName.split(":")[0];
    }

    private static String getPath(String registryName) {
        return registryName.split(":")[1];
    }
}