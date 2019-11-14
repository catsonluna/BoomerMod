package me.pinkulu.boomer;

import me.pinkulu.boomer.command.BoomerCommand;
import me.pinkulu.boomer.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tk.npecode.config.Configuration;

import java.io.File;
import java.io.IOException;

@Mod(modid = BoomerMod.MODID, version = BoomerMod.VERSION, name = BoomerMod.NAME, acceptedMinecraftVersions = BoomerMod.acceptedMineshaftVersions)
public class BoomerMod {

    static final String MODID = "boomermod";
    static final String VERSION = "1.0.2";
    static final String NAME = "BoomerMod";
    static final String acceptedMineshaftVersions = "[1.8.9]";
    @Mod.Instance(BoomerMod.MODID)
    public static BoomerMod INSTANCE;
    private ResourceLocation soundLocation = new ResourceLocation("boomer", "boomer");
    public Configuration configuration;

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        try {
            configuration = Configuration.newJsonConfig(new File(Minecraft.getMinecraft().mcDataDir, "config/boomer_mod_config.json")).addClass(Config.class).initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientCommandHandler.instance.registerCommand(new BoomerCommand());
    }

    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent e) {
        String msg = e.message.getUnformattedText();
        //SkyWars
        if (Config.enabled) {
            if (msg.startsWith("You died")) {
                Minecraft.getMinecraft().thePlayer.playSound(soundLocation.toString(), 1.0f, 1.0f);
            } else if (msg.startsWith("+") && msg.contains("Kill") && msg.contains("coins")) {
                Minecraft.getMinecraft().thePlayer.playSound(soundLocation.toString(), 1.0f, 1.0f);
                //BedWars
            } else if (msg.endsWith("FINAL KILL")) {
                Minecraft.getMinecraft().thePlayer.playSound(soundLocation.toString(), 1.0f, 1.0f);
                //Survival
            } else if (Minecraft.getMinecraft().thePlayer.isDead) {
                Minecraft.getMinecraft().thePlayer.playSound(soundLocation.toString(), 1.0f, 1.0f);
            }
        }
    }
}