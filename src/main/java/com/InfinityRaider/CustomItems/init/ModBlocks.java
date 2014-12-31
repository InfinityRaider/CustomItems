package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.CustomItems;
import com.InfinityRaider.CustomItems.block.CustomBlock;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.IOHelper;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static void init(String[] blocksData) {
        for(int i=0;i<blocksData.length;i++) {
            String[] data = IOHelper.getData(blocksData[i]);
            //{blockname,texturename,material,tool,hardness,resistance,lightlevel,harvestlevel}
            if(data.length==8) {
                CustomItems.blocks.add(new CustomBlock(IOHelper.getMaterial(data[2]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
                CustomItems.blocks.get(i).setBlockName(Reference.MOD_ID.toLowerCase()+":"+data[1]);
                CustomItems.blocks.get(i).setHarvestLevel(data[3], Integer.parseInt(data[7]));
                GameRegistry.registerBlock(CustomItems.blocks.get(i), data[1]);
                LanguageRegistry.instance().addStringLocalization(CustomItems.blocks.get(i).getUnlocalizedName()+".name","en_US", data[0]);
            }
            else {
                LogHelper.info("Error parsing "+blocksData[i]);
            }
        }
    }
}
