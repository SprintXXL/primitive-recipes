package com.SprintXXL.primitiverecipes.recipes.removal;

import com.SprintXXL.primitiverecipes.PrimitiveRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public final class RecipeRemovalHandler {

    private RecipeRemovalHandler() {}

    public static void removeRecipe(RegistryEvent.Register<IRecipe> event, ResourceLocation id) {

        IForgeRegistry<IRecipe> registry = event.getRegistry();

        IRecipe recipe = registry.getValue(id);

        if (recipe == null) {
            PrimitiveRecipes.LOGGER.warn("[Primitive Recipes] Could not find recipe to remove: {}", id);
            return;
        }

        registry.register(new DisabledRecipe().setRegistryName(id));

        PrimitiveRecipes.LOGGER.info("[Primitive Recipes] Removed recipe: {}", id);
    }
}
