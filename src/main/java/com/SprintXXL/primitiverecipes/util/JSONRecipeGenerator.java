package com.SprintXXL.primitiverecipes.util;

import com.SprintXXL.primitiverecipes.recipeobjects.RecipeObjectDefinition;
import com.SprintXXL.primitiverecipes.recipes.RecipeDefinition;
import com.SprintXXL.primitiverecipes.recipes.RecipeRegistry;
import com.SprintXXL.primitiverecipes.recipes.shape.RecipeShape;
import com.SprintXXL.primitiverecipes.recipes.shape.ShapelessRecipe;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONRecipeGenerator {

    public static void main(String[] args) {

        RecipeRegistry.init();

        for (RecipeDefinition recipe : RecipeRegistry.getAllRecipes()) {

            generateRecipe(recipe);
        }
    }

    private static void generateRecipe(RecipeDefinition recipe) {

        Path path = Paths.get(
                "src/main/resources/assets/primitiverecipes/recipes",
                recipe.getID() + ".json"
        );

        String json = buildJSON(recipe);

        writeFile(path, json);
    }

    private static String buildJSON(RecipeDefinition recipe) {

        RecipeShape shape = recipe.getShape();

        if (shape instanceof ShapelessRecipe) {
            return buildShapelessJSON(recipe, (ShapelessRecipe) shape);
        }

        throw new IllegalArgumentException("Unknown recipe shape: " + shape);
    }

    private static String buildShapelessJSON(RecipeDefinition recipe, ShapelessRecipe shape) {

        for (RecipeObjectDefinition ingredient : shape.getIngredients()) {

            return
                    "{\n" +
                            "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                            "  \"ingredients\": [\n" +
                            "    {\n" +
                            "      \"item\": \"" + ingredient.getID() + "\",\n" +
                            "      \"data\": 0\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"result\": {\n" +
                            "    \"item\": \"" + recipe.getOutput().getID() + "\",\n" +
                            "    \"count\": " + recipe.getCount() + "\n" +
                            "  }\n" +
                            "}";
        }

        return null;
    }

    private static void writeFile(Path path, String contents) {

        try {
            Files.createDirectories(path.getParent());

            Files.write(
                    path,
                    contents.getBytes(StandardCharsets.UTF_8)
            );

            System.out.println("Generated: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}