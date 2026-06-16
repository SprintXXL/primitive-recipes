package com.SprintXXL.primitiverecipes.recipes.registry;

import com.SprintXXL.primitiverecipes.recipes.shared.Runtime;
import com.SprintXXL.primitiverecipes.recipes.crafting.CraftingRecipe;
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

            event.getRegistry().register(JavaRecipeFactory.create(definition));
        }
    }

    private static boolean isForgeRecipe(CraftingRecipe definition) {
        return definition.getRuntime() == Runtime.FORGE;
    }
}
