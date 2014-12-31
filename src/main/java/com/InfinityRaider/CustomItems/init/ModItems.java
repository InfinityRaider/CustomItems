package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.CustomItems;
import com.InfinityRaider.CustomItems.item.CustomItem;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.IOHelper;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static void init(String[] itemsData) {
        for(int i=0;i<itemsData.length;i++) {
            String[] data = IOHelper.getData(itemsData[i]);
            //{itemname,texturename,maxstackssize}
            if(data.length==3) {
                CustomItems.items.add(new CustomItem(Integer.parseInt(data[2])));
                CustomItems.items.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+data[1]);
                GameRegistry.registerItem(CustomItems.items.get(i), data[1]);
                LanguageRegistry.instance().addStringLocalization(CustomItems.items.get(i).getUnlocalizedName()+".name","en_US", data[0]);
            }
            else {
                LogHelper.info("Error parsing "+itemsData[i]);
            }
        }
    }
}
