package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.handler.ConfigurationHandler;
import com.InfinityRaider.CustomItems.handler.InputHandler;
import com.InfinityRaider.CustomItems.item.CustomRecord;
import com.InfinityRaider.CustomItems.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModRecords {
    public static CustomRecord[] records;
    public static void init() {
        String recordData[] = InputHandler.getArray(ConfigurationHandler.records);
        records = new CustomRecord[recordData.length];
        for(int i=0;i<recordData.length;i++) {
            String[] data = InputHandler.getRecordData(recordData[i]);
            records[i] = new CustomRecord(data[0]);
            GameRegistry.registerItem(records[i],"record_"+data[1]);
            records[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":record_"+data[1]);
            LanguageRegistry.instance().addStringLocalization(records[i].getUnlocalizedName()+".name","en_US","Music Disc");
        }
    }
}
