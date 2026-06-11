package com.SprintXXL.primitiverecipes.library.recipes.register;

import com.SprintXXL.primitiverecipes.library.recipes.RecipeDefinition;
import com.SprintXXL.primitiverecipes.library.recipes.RecipeRegistry;
import com.SprintXXL.primitiverecipes.library.recipes.RecipeType;
import com.SprintXXL.primitiverecipes.util.factories.JavaRecipeFactory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RecipeRegister {

    private RecipeRegister() {}

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        for (RecipeDefinition definition : RecipeRegistry.getAllRecipes()) {

            if (definition.getType() != RecipeType.JAVA) {
                continue;
            }

            event.getRegistry().register(
                    JavaRecipeFactory.create(definition)
            );
        }
    }
}
