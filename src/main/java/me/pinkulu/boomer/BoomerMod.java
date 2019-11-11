package me.pinkulu.boomer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;





@Mod(modid = BoomerMod.MODID, version = BoomerMod.VERSION, name = BoomerMod.NAME, acceptedMinecraftVersions = BoomerMod.acceptedMineshaftVersions)

public class BoomerMod {

    static final String MODID = "boomer";
    static final String VERSION ="1.0";
    static final String NAME = "BoomerMod";
    static final String acceptedMineshaftVersions = "[1.8.9]";
    private Object ITextComponent;

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    ResourceLocation s = new ResourceLocation("boomer", "boomer");
    SoundEvent event = new SoundEvent();

    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent e) {
        String msg = e.message.getUnformattedText();
        if (msg.startsWith("You died")) {
            Minecraft.getMinecraft().thePlayer.playSound("boomer:boomer", 5.0f, 0.5f);
        }
    }
}
