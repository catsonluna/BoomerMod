package me.pinkulu.boomer.command;

import me.pinkulu.boomer.BoomerMod;
import me.pinkulu.boomer.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class BoomerCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "boomermod";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("boomer");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args[0].equalsIgnoreCase("toggle")) {
            Config.enabled = !Config.enabled;
            String s = Config.enabled ? EnumChatFormatting.GREEN + "Enabled" : EnumChatFormatting.RED + "Disabled";
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Successfully " + s + " the mod."));
            try {
                BoomerMod.INSTANCE.configuration.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
