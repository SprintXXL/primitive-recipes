package com.SprintXXL.primitiverecipes.util;

import com.SprintXXL.primitiverecipes.recipes.ModRecipes;
import com.SprintXXL.primitiverecipes.recipes.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipes.resources.ResourceDefinition;
import com.SprintXXL.primitiverecipes.recipes.RecipeDefinition;
import com.SprintXXL.primitiverecipes.recipes.RecipeRegistry;
import com.SprintXXL.primitiverecipes.recipes.shape.RecipeShape;
import com.SprintXXL.primitiverecipes.recipes.shape.ShapelessRecipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class JSONRecipeGenerator {

    public static void main(String[] args) {

        ModRecipes.initModRecipes();

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

        if (shape instanceof ShapedRecipe) {
            return buildShapedJSON(recipe, (ShapedRecipe) shape);
        }

        throw new IllegalArgumentException("Unknown recipe shape: " + shape);
    }

    private static String buildShapelessJSON(RecipeDefinition recipe, ShapelessRecipe shape) {

        JsonObject json = new JsonObject();

        json.addProperty(
                "type",
                "minecraft:crafting_shapeless"
        );

        JsonArray ingredients = new JsonArray();

        for (ResourceDefinition ingredient : shape.getIngredients()) {

            JsonObject ingredientJson = new JsonObject();

            ingredientJson.addProperty(
                    "item",
                    ingredient.getID()
            );

            ingredients.add(ingredientJson);
        }

        json.add(
                "ingredients",
                ingredients
        );

        JsonObject result = new JsonObject();

        result.addProperty(
                "item",
                recipe.getOutput().getID()
        );

        result.addProperty(
                "count",
                recipe.getCount()
        );

        json.add(
                "result",
                result
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(json);
    }

    private static String buildShapedJSON(RecipeDefinition recipe, ShapedRecipe shape) {

        JsonObject json = new JsonObject();

        json.addProperty(
                "type",
                "minecraft:crafting_shaped"
        );

        JsonArray pattern = new JsonArray();

        for (String row : shape.getPattern()) {
            pattern.add(row);
        }

        json.add(
                "pattern",
                pattern
        );

        JsonObject key = new JsonObject();

        for (Map.Entry<Character, ResourceDefinition> entry : shape.getKeys().entrySet()) {

            Character symbol = entry.getKey();

            ResourceDefinition resource = entry.getValue();

            JsonObject ingredient = new JsonObject();

            ingredient.addProperty(
                    "item",
                    resource.getID()
            );

            key.add(
                    String.valueOf(symbol),
                    ingredient
            );
        }

        json.add(
                "key",
                key
        );

        JsonObject result = new JsonObject();

        result.addProperty(
                "item",
                recipe.getOutput().getID()
        );

        result.addProperty(
                "count",
                recipe.getCount()
        );

        json.add(
                "result",
                result
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(json);
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