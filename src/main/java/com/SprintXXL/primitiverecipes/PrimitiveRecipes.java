package com.SprintXXL.primitiverecipes;

import com.SprintXXL.primitiverecipes.util.commands.DumpResources;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.SprintXXL.primitiverecipes.Reference.*;
import static com.SprintXXL.primitiverecipes.recipes.crafting.definitions.CoreCraftingRecipes.initCoreCraftingRecipes;
import static com.SprintXXL.primitiverecipes.recipes.crafting.definitions.ModCraftingRecipes.initModCraftingRecipes;
import static com.SprintXXL.primitiverecipes.recipes.factory.ModFactoryRecipes.initModFactoryRecipes;
import static com.SprintXXL.primitiverecipes.recipes.removal.RecipeRemovalRegistry.registerRecipeRemovals;
import static com.SprintXXL.primitiverecipes.resources.ModResources.initModResources;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class PrimitiveRecipes {

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {

        event.registerServerCommand(
                new DumpResources()
        );
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        initModResources();
        registerRecipeRemovals();
        initCoreCraftingRecipes();
        initModCraftingRecipes();
        initModFactoryRecipes();
    }
}
