package com.SprintXXL.primitiverecipes.recipes;

import com.SprintXXL.primitiverecipes.recipes.crafting.CraftingRecipe;
import com.SprintXXL.primitiverecipes.recipes.crafting.ModCraftingRecipes;

import java.util.*;

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
        RECIPES.put(recipe.getID(), recipe);
        ALL_RECIPES.add(recipe);
    }

    public static void init() {

        ModCraftingRecipes.initModCraftingRecipes();
    }
}
