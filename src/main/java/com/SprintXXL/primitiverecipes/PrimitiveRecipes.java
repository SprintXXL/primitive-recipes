package com.SprintXXL.primitiverecipes;

import com.SprintXXL.primitiverecipes.recipes.RecipeRegistry;
import com.SprintXXL.primitiverecipes.resources.ResourceRegistry;
import com.SprintXXL.primitiverecipes.util.resourcegen.DumpResources;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import static com.SprintXXL.primitiverecipes.Reference.*;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class PrimitiveRecipes {

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {

        event.registerServerCommand(
                new DumpResources()
        );
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        RecipeRegistry.init();
        ResourceRegistry.init();
    }
}
