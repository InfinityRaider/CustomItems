package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.CustomItems;
import com.InfinityRaider.CustomItems.item.CustomRecord;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.IOHelper;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModRecords {
    public static CustomRecord[] records;
    public static void init(String[] recordsData) {
        for(int i=0;i<recordsData.length;i++) {
            String[] data = IOHelper.getData(recordsData[i]);
            //{soundfile,texture}
            if(data.length==2) {
                CustomItems.records.add(new CustomRecord(data[0]));
                CustomItems.records.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":record_" + data[1]);
                GameRegistry.registerItem(CustomItems.records.get(i), "record_"+data[1]);
                LanguageRegistry.instance().addStringLocalization(CustomItems.items.get(i).getUnlocalizedName() + ".name", "en_US", "Music Disc");
            }
            else {
                LogHelper.info("Error parsing " + recordsData[i]);
            }
        }
    }
}
