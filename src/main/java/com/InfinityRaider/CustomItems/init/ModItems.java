package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.handler.ConfigurationHandler;
import com.InfinityRaider.CustomItems.handler.InputHandler;
import com.InfinityRaider.CustomItems.item.CustomItem;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static Item[] items;
    public static void init() {
        String[] itemsData = InputHandler.getArray(ConfigurationHandler.items);
        items = new Item[itemsData.length];
        for(int i=0;i<itemsData.length;i++) {
            if(Reference.debug) {LogHelper.info("Adding item: " + itemsData[i]);}
            String unlocalizedName = InputHandler.getTexture(itemsData[i]);
            items[i] = new CustomItem(InputHandler.getStackSize(itemsData[i]));
            GameRegistry.registerItem(items[i], unlocalizedName);
            items[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":"+unlocalizedName);
            LanguageRegistry.instance().addStringLocalization(items[i].getUnlocalizedName()+".name","en_US", InputHandler.getName(itemsData[i]));
        }
    }
}
