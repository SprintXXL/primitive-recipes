package com.SprintXXL.primitiverecipes.recipes.removal;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipeRemovalRegistry {

    private RecipeRemovalRegistry() {}

    private static final List<ResourceLocation> REMOVED_RECIPES = new ArrayList<>();

    public static List<ResourceLocation> getRemovedRecipes() {
        return Collections.unmodifiableList(REMOVED_RECIPES);
    }

    public static void register(ResourceLocation id) {
        REMOVED_RECIPES.add(id);
    }

    public static void remove(String id) {
        register(new ResourceLocation("minecraft", id));
    }

    public static void registerRecipeRemovals() {

        remove("oak_planks");
        remove("birch_planks");
        remove("spruce_planks");
        remove("jungle_planks");
        remove("acacia_planks");
        remove("dark_oak_planks");

        remove("furnace");
        remove("chest");
        remove("crafting_table");
        remove("hopper");
        remove("bucket");
        remove("stick");

        remove("leather_helmet");
        remove("leather_chestplate");
        remove("leather_leggings");
        remove("leather_boots");

        remove("white_bed");
        remove("black_bed");
        remove("black_bed_from_white_bed");
        remove("red_bed");
        remove("red_bed_from_white_bed");
        remove("blue_bed");
        remove("blue_bed_from_white_bed");
        remove("green_bed");
        remove("green_bed_from_white_bed");
        remove("lime_bed");
        remove("lime_bed_from_white_bed");
        remove("cyan_bed");
        remove("cyan_bed_from_white_bed");
        remove("yellow_bed");
        remove("yellow_bed_from_white_bed");
        remove("light_blue_bed");
        remove("light_blue_bed_from_white_bed");
        remove("light_gray_bed");
        remove("light_gray_bed_from_white_bed");
        remove("brown_bed");
        remove("brown_bed_from_white_bed");
        remove("magenta_bed");
        remove("magenta_bed_from_white_bed");
        remove("gray_bed");
        remove("gray_bed_from_white_bed");
        remove("orange_bed");
        remove("orange_bed_from_white_bed");
        remove("pink_bed");
        remove("pink_bed_from_white_bed");
        remove("purple_bed");
        remove("purple_bed_from_white_bed");
    }
}
