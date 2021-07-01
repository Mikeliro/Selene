package net.mehvahdjukaar.selene.setup;

import net.mehvahdjukaar.selene.client.FluidParticleColors;
import net.mehvahdjukaar.selene.fluids.FluidTextures;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void onResourcePackChanged(ModelBakeEvent event) {
        FluidParticleColors.refresh();
    }

    //textures
    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (event.getMap().location().equals(AtlasTexture.LOCATION_BLOCKS)) {
            FluidTextures.getTexturesToStitch().forEach(event::addSprite);
        }
    }
}