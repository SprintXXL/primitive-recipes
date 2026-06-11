package com.SprintXXL.primitiverecipes.library.resources;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public final class ResourceResolver {

    private ResourceResolver() {}

    public static Item getItem(ResourceDefinition resource) {

        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(resource.getID()));

        if (item == null) {
            throw new IllegalArgumentException("Unknown item: " + resource.getID());
        }

        return item;
    }

    public static ItemStack createStack(ResourceDefinition resource) {
        return new ItemStack(getItem(resource));
    }

    public static ItemStack createStack(ResourceDefinition resource, int count) {
        return new ItemStack(getItem(resource), count);
    }
}