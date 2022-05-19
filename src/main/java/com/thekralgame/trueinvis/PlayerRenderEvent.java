package com.thekralgame.trueinvis;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "trueinvis", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerRenderEvent {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void preRenderPlayer(final RenderPlayerEvent.Pre event){
        if (event.getPlayer().getActivePotionEffect(Effects.INVISIBILITY) != null){
            event.setCanceled(true);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void  renderHand(final RenderHandEvent event){
        assert Minecraft.getInstance().player != null;
        if (Minecraft.getInstance().player.getActivePotionEffect(Effects.INVISIBILITY) != null) {
            event.setCanceled(true);
        }
    }
}
