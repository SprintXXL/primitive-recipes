package com.SprintXXL.primitiverecipes.recipes.crafting;

import com.SprintXXL.primitiverecipes.recipes.RecipeRegistry;
import com.SprintXXL.primitiverecipes.util.factories.JavaRecipeFactory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegisterJavaRecipe {

    private RegisterJavaRecipe() {}

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        for (CraftingRecipe definition : RecipeRegistry.getAllRecipes()) {

            if (definition.getType() != CRType.JAVA) {
                continue;
            }

            event.getRegistry().register(
                    JavaRecipeFactory.create(definition)
            );
        }
    }
}
