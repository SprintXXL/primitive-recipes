package com.SprintXXL.primitiverecipes.util.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DumpResources extends CommandBase {

    private static final String OUTPUT_DIRECTORY = "D:\\Work\\My Modpack\\Mods\\Primitive Recipes\\src\\tools\\java\\com\\SprintXXL\\resourcegenerator\\dumps";

    @Override
    public String getName() {
        return "dumpresources";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/dumpresources <modid>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (args.length != 1) {
            throw new WrongUsageException(getUsage(sender));
        }

        String modid = args[0];

        List<String> lines = new ArrayList<>();

        for (Item item : ForgeRegistries.ITEMS) {
            ResourceLocation name = item.getRegistryName();

            if (name == null) {
                continue;
            }

            if (!name.getNamespace().equals(modid)) {
                continue;
            }

            lines.add(name.toString());

            Path path = Paths.get(
                    OUTPUT_DIRECTORY,
                    modid + ".txt"
            );

            try {

                Files.createDirectories(path.getParent());

                Files.write(
                        path,
                        lines,
                        StandardCharsets.UTF_8
                );

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        sender.sendMessage(
                new TextComponentString(
                        "Dumped " + lines.size() + " items for modid: " + modid
                )
        );
    }
}
