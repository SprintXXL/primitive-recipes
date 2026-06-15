package com.SprintXXL.primitiverecipes;

import com.SprintXXL.primitiverecipes.recipes.registry.RecipeRegistry;
import com.SprintXXL.primitiverecipes.resources.ResourceRegistry;
import com.SprintXXL.primitiverecipes.util.resourcegen.DumpResources;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.SprintXXL.primitiverecipes.Reference.*;

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

        RecipeRegistry.init();
        ResourceRegistry.init();
    }
}
