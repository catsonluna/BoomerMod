package me.pinkulu.boomer;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;


public class Commands extends CommandBase {

    @Override
    public String getCommandName() {
        return "boomer";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/boomer";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] strings) throws CommandException{
        Minecraft.getMinecraft().thePlayer.sendChatMessage("BoomerMod made by Pinkulu. Version 1.1");
    }
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
