package com.SprintXXL.primitiverecipes.recipes.registry;

import com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.CraftingRecipe;

import java.util.*;

import static com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.external.ExternalCraftingRecipes.initExternalCraftingRecipes;
import static com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.mod.ModCraftingRecipes.initModCraftingRecipes;

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

        initModCraftingRecipes();
        initExternalCraftingRecipes();
    }
}
