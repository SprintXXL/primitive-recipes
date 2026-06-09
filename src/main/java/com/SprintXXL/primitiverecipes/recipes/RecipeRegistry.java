package com.SprintXXL.primitiverecipes.recipes;

import java.util.*;

import static com.SprintXXL.primitiverecipes.recipes.ModRecipes.*;

public class RecipeRegistry {

    private RecipeRegistry() {}

    private static final Map<String, RecipeDefinition> RECIPES =
            new HashMap<>();

    private static final List<RecipeDefinition> ALL_RECIPES =
            new ArrayList<>();

    public static List<RecipeDefinition> getAllRecipes() {
        return Collections.unmodifiableList(ALL_RECIPES);
    }

    public static RecipeDefinition getRecipe(String id) {
        return RECIPES.get(id);
    }

    public static void register(RecipeDefinition recipe) {
        RECIPES.put(recipe.getID(), recipe);
        ALL_RECIPES.add(recipe);
    }

    public static void init() {

        register(TEST);
    }
}
