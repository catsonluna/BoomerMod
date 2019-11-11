package me.pinkulu.boomer;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = BoomerMod.MODID, version = BoomerMod.VERSION, name = BoomerMod.NAME, acceptedMinecraftVersions = BoomerMod.acceptedMineshaftVersions)
public class BoomerMod {

    static final String MODID = "boomer";
    static final String VERSION = "1.0";
    static final String NAME = "BoomerMod";
    static final String acceptedMineshaftVersions = "[1.8.9]";
    private ResourceLocation soundLocation = new ResourceLocation("boomer", "boomer");

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent e) {
        String msg = e.message.getUnformattedText();
        if (msg.startsWith("You died")) {
            Minecraft.getMinecraft().thePlayer.playSound(soundLocation.toString(), 1.0f, 1.0f);
        }
    }
}
