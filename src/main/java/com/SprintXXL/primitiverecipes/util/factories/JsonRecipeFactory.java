package com.SprintXXL.primitiverecipes.util.factories;

import com.SprintXXL.primitiverecipes.library.recipes.ModRecipes;
import com.SprintXXL.primitiverecipes.library.recipes.RecipeType;
import com.SprintXXL.primitiverecipes.library.recipes.data.RecipeIngredient;
import com.SprintXXL.primitiverecipes.library.recipes.data.json.JsonRecipeData;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.ShapedRecipe;
import com.SprintXXL.primitiverecipes.library.recipes.RecipeDefinition;
import com.SprintXXL.primitiverecipes.library.recipes.RecipeRegistry;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.RecipeShape;
import com.SprintXXL.primitiverecipes.library.recipes.data.shape.ShapelessRecipe;
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

public class JsonRecipeFactory {

    public static void main(String[] args) {

        ModRecipes.initModRecipes();

        for (RecipeDefinition recipe : RecipeRegistry.getAllRecipes()) {

            if (recipe.getType() != RecipeType.JSON) {
                continue;
            }

            generateRecipe(recipe);
        }
    }

    private static void generateRecipe(RecipeDefinition recipe) {

        Path path = Paths.get(
                "src/main/resources/assets/primitiverecipes/library",
                recipe.getID() + ".json"
        );

        String json = buildJSON(recipe);

        writeFile(path, json);
    }

    private static String buildJSON(RecipeDefinition recipe) {

        JsonRecipeData data = (JsonRecipeData) recipe.getData();

        RecipeShape shape = data.getShape();

        if (shape instanceof ShapelessRecipe) {
            return buildShapelessJSON(data, (ShapelessRecipe) shape);
        }

        if (shape instanceof ShapedRecipe) {
            return buildShapedJSON(data, (ShapedRecipe) shape);
        }

        throw new IllegalArgumentException("Unknown recipe shape: " + shape);
    }

    private static String buildShapelessJSON(JsonRecipeData data, ShapelessRecipe shape) {

        JsonObject json = new JsonObject();

        json.addProperty(
                "type",
                "minecraft:crafting_shapeless"
        );

        JsonArray ingredients = new JsonArray();

        for (RecipeIngredient ingredient : shape.getIngredients()) {

            JsonObject ingredientJson = new JsonObject();

            ingredientJson.addProperty(
                    "item",
                    ingredient.getResource().getID()
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
                data.getOutput().getID()
        );

        result.addProperty(
                "count",
                data.getCount()
        );

        json.add(
                "result",
                result
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(json);
    }

    private static String buildShapedJSON(JsonRecipeData data, ShapedRecipe shape) {

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

        for (Map.Entry<Character, RecipeIngredient> entry : shape.getKeys().entrySet()) {

            Character symbol = entry.getKey();

            RecipeIngredient resource = entry.getValue();

            JsonObject ingredient = new JsonObject();

            ingredient.addProperty(
                    "item",
                    resource.getResource().getID()
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
                data.getOutput().getID()
        );

        result.addProperty(
                "count",
                data.getCount()
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