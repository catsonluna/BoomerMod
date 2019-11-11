package me.pinkulu.boomer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



@Mod(modid = BoomerMod.MODID, version = BoomerMod.VERSION, name = BoomerMod.NAME, acceptedMinecraftVersions = BoomerMod.acceptedMinecraftVersions)

public class BoomerMod {

    static final String MODID = "boomermod";
    static final String VERSION ="1.0";
    static final String NAME = "BoomerMod";
    static final String acceptedMinecraftVersions = "[1.8.9]";

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent e) {
        String msg = e.message.getUnformattedText();
        if (msg.startsWith("You died")) {
            Minecraft.getMinecraft().thePlayer.playSound("boomer:boomer", 5.0f, 0.5f);
        }
    }
}
