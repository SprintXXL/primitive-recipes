package com.SprintXXL.primitiverecipes.util.resourcegen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.SprintXXL.primitiverecipes.util.resourcegen.ResourceTypeResolver.getResourceType;

public class ResourceGenerator {

    private static final String DUMPS_FOLDER = "src/main/java/com/SprintXXL/primitiverecipes/util/resourcegen/dumps/";
    private static final String OUTPUT_FOLDER = "src/main/java/com/SprintXXL/primitiverecipes/resources";

    public static void main(String[] args) throws IOException {

        generateAllDumpFiles();
    }

    private static void generateAllDumpFiles() throws IOException {

        StringBuilder ids = new StringBuilder();
        StringBuilder definitions = new StringBuilder();
        StringBuilder registers = new StringBuilder();

        Path dumpsFolder = Paths.get(DUMPS_FOLDER);

        for (Path dumpFile : Files.list(dumpsFolder).toList()) {

            if (!dumpFile.toString().endsWith(".txt")) {
                continue;
            }

            generateForDumpFile(dumpFile, ids, definitions, registers);
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

    private static void generateForDumpFile(Path dumpFile, StringBuilder ids, StringBuilder definitions, StringBuilder registers) throws IOException {

        String modid = getModidFromDumpFile(dumpFile);

        List<String> registryNames = Files.readAllLines(dumpFile);

        for (String registryName : registryNames) {

            if (registryName.trim().isEmpty()) {
                continue;
            }

            ids.append(buildIDLine(registryName)).append("\n");
            definitions.append(buildDefinitionLine(registryName, modid)).append("\n");
            registers.append(buildRegisterLine(registryName)).append("\n");
        }
    }

    private static String buildResourceIDsFile(String body) {
        return "package com.SprintXXL.primitiverecipes.library.resources;\n\n" +
                "public final class ResourceIDs {\n\n" +
                "    private ResourceIDs() {}\n\n" +
                body +
                "\n}";
    }

    private static String buildModResourcesFile(String definitions, String registers) {
        return "package com.SprintXXL.primitiverecipes.library.resources;\n\n" +
                "import static com.SprintXXL.primitiverecipes.library.resources.ResourceRegistry.register;\n\n" +
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

    private static String getModidFromDumpFile(Path dumpFile) {

        String fileName = dumpFile.getFileName().toString();

        return fileName.replace(".txt", "");
    }

    private static String getConstantName(String registryName) {

        String[] path = registryName.split(":");

        if (path.length != 2) {
            return null;
        }

        return path[1].toUpperCase();
    }
}