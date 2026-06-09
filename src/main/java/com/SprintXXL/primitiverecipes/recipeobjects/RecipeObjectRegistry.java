package com.SprintXXL.primitiverecipes.recipeobjects;

import java.util.*;

import static com.SprintXXL.primitiverecipes.recipeobjects.ModRecipeObjects.*;

public final class RecipeObjectRegistry {

    private RecipeObjectRegistry() {}

    private static final Map<String, RecipeObjectDefinition> INGREDIENTS =
            new HashMap<>();

    private static final List<RecipeObjectDefinition> ALL_INGREDIENTS =
            new ArrayList<>();

    public static List<RecipeObjectDefinition> getAllIngredients() {
        return Collections.unmodifiableList(ALL_INGREDIENTS);
    }

    public static RecipeObjectDefinition getIngredient(String id) {
        return INGREDIENTS.get(id);
    }

    public static void register(RecipeObjectDefinition ingredient) {
        INGREDIENTS.put(ingredient.getID(), ingredient);
        ALL_INGREDIENTS.add(ingredient);
    }

    public static void init() {

        register(DIRT);
    }
}
