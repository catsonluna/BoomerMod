package me.pinkulu.boomer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
;


@Mod(modid = "boomer", version = "1.0", name = "boomer", acceptedMinecraftVersions = "[1.8.9]")

public class Boomer {

    private String nickData;
    private String msg;



    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent e) {
        if (this.msg.startsWith("You died") ) {
            SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
            if (soundHandler == null || Minecraft.getMinecraft().theWorld == null) return;
            soundHandler.playSound(PositionedSoundRecord.create(new ResourceLocation("OkBoomer"),
                    (float) Minecraft.getMinecraft().thePlayer.posX, (float) Minecraft.getMinecraft().thePlayer.posY, (float) Minecraft.getMinecraft().thePlayer.posZ));
        }
    }
}
