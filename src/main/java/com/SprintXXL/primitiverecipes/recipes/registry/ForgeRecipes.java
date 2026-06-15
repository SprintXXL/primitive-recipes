package com.SprintXXL.primitiverecipes.recipes.registry;

import com.SprintXXL.primitiverecipes.recipes.shared.RecipeRuntime;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.RecipeData;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.external.ExternalRecipeData;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.mod.BasicRecipeData;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.data.mod.CustomRecipeData;
import com.SprintXXL.primitiverecipes.recipes.types.crafting.definitions.CraftingRecipe;
import com.SprintXXL.primitiverecipes.recipes.removal.RecipeRemovalHandler;
import com.SprintXXL.primitiverecipes.recipes.removal.RecipeRemovalRegistry;
import com.SprintXXL.primitiverecipes.util.JavaRecipeFactory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ForgeRecipes {

    private ForgeRecipes() {}

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        RecipeRemovalRegistry.registerRecipeRemovals();

        for (ResourceLocation id : RecipeRemovalRegistry.getRemovedRecipes()) {
            RecipeRemovalHandler.removeRecipe(event, id);
        }

        for (CraftingRecipe definition : RecipeRegistry.getAllRecipes()) {

            if (!isForgeRecipe(definition)) {
                continue;
            }

            IRecipe recipe = JavaRecipeFactory.create(definition);

            if (recipe == null) {
                continue;
            }

            event.getRegistry().register(recipe);
        }
    }

    private static boolean isForgeRecipe(CraftingRecipe definition) {

        RecipeData data = definition.getData();

        if (data instanceof BasicRecipeData) {
            return true;
        }

        if (data instanceof CustomRecipeData) {
            return ((CustomRecipeData) data).getRuntime() == RecipeRuntime.FORGE;
        }

        if (data instanceof ExternalRecipeData) {
            return ((ExternalRecipeData) data).getRuntime() == RecipeRuntime.FORGE;
        }

        return false;
    }
}
