package com.InfinityRaider.CustomItems;

import com.InfinityRaider.CustomItems.handler.ConfigurationHandler;
import com.InfinityRaider.CustomItems.init.*;
import com.InfinityRaider.CustomItems.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.VERSION)
public class CustomItems {
    @Mod.Instance(Reference.MOD_ID)
    public static CustomItems instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //set up config
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        //initialize blocks and items
        ModBlocks.init();
        ModItems.init();
        ModFluids.init();
        ModTools.init();
        ModArmor.init();
        ModRecords.init();
    }
}
