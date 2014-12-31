package com.InfinityRaider.CustomItems.handler;

import com.InfinityRaider.CustomItems.CustomItems;
import com.InfinityRaider.CustomItems.fluid.CustomFluid;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.TextureStitchEvent;

public class FluidTextureEventHandler {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void applyTextureToAtlas(TextureStitchEvent.Post event) {
        if(event.map.getTextureType()==0) {
            for(CustomFluid fluid: CustomItems.fluids) {
                fluid.setIcons(fluid.getBlock().getIcon(0,0),fluid.getBlock().getIcon(2,0));
            }
        }
    }
}
