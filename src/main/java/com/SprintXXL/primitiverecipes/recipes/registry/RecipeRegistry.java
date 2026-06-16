package com.SprintXXL.primitiverecipes.recipes.registry;

import com.SprintXXL.primitiverecipes.recipes.crafting.CraftingRecipe;

import java.util.*;

import static com.SprintXXL.primitiverecipes.recipes.crafting.definitions.CoreCraftingRecipes.initCoreCraftingRecipes;
import static com.SprintXXL.primitiverecipes.recipes.crafting.definitions.ModCraftingRecipes.initModCraftingRecipes;

public final class RecipeRegistry {

    private RecipeRegistry() {}

    private static final Map<String, CraftingRecipe> RECIPES =
            new HashMap<>();

    private static final List<CraftingRecipe> ALL_RECIPES =
            new ArrayList<>();

    public static List<CraftingRecipe> getAllRecipes() {
        return Collections.unmodifiableList(ALL_RECIPES);
    }

    public static CraftingRecipe getRecipe(String id) {
        return RECIPES.get(id);
    }

    public static void register(CraftingRecipe recipe) {

        if (RECIPES.containsKey(recipe.getID())) {
            throw new IllegalArgumentException("Duplicate recipe ID: " + recipe.getID());
        }

        RECIPES.put(recipe.getID(), recipe);
        ALL_RECIPES.add(recipe);
    }

    public static void init() {

        initCoreCraftingRecipes();
        initModCraftingRecipes();
    }
}
