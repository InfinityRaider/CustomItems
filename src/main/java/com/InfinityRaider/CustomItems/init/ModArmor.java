package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.CustomItems;
import com.InfinityRaider.CustomItems.item.CustomArmor;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.IOHelper;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import com.InfinityRaider.CustomItems.utility.RegisterHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmor {
    public static void init(String[] itemsData) {
        for(int i=0;i<itemsData.length;i++) {
            String[] data = IOHelper.getData(itemsData[i]);
            //{materialname,durability,helmetreduction,chestreduction,leggingreduction,bootsreduction,enchantability}
            if(data.length==7) {
                CustomItems.armorMaterials.add(EnumHelper.addArmorMaterial(data[0], Integer.parseInt(data[1]), new int[] {Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])}, Integer.parseInt(data[6])));
                if(Integer.parseInt(data[2])>=0) {
                    CustomItems.helmets.add(new CustomArmor(CustomItems.armorMaterials.get(i),2,0,data[0]));
                    CustomItems.helmets.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[0] + "Helmet");
                    RegisterHelper.registerItem(CustomItems.helmets.get(i), data[0] + "Helmet");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.helmets.get(i).getUnlocalizedName()+".name","en_US",data[0].substring(0, 1).toUpperCase()+data[0].substring(1)+" Helmet");
                }
                if(Integer.parseInt(data[3])>=0) {
                    CustomItems.chestplates.add(new CustomArmor(CustomItems.armorMaterials.get(i),2,1,data[0]));
                    CustomItems.chestplates.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[0] + "Chestplate");
                    RegisterHelper.registerItem(CustomItems.chestplates.get(i), data[0] + "Chestplate");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.chestplates.get(i).getUnlocalizedName()+".name","en_US",data[0].substring(0, 1).toUpperCase()+data[0].substring(1)+" Chestplate");
                }
                if(Integer.parseInt(data[4])>=0) {
                    CustomItems.leggings.add(new CustomArmor(CustomItems.armorMaterials.get(i),2,2,data[0]));
                    CustomItems.leggings.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[0] + "Legs");
                    RegisterHelper.registerItem(CustomItems.leggings.get(i), data[0] + "Legs");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.leggings.get(i).getUnlocalizedName()+".name","en_US",data[0].substring(0, 1).toUpperCase()+data[0].substring(1)+" Legs");
                }
                if(Integer.parseInt(data[5])>=0) {
                    CustomItems.boots.add(new CustomArmor(CustomItems.armorMaterials.get(i),2,3,data[0]));
                    CustomItems.boots.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[0] + "Boots");
                    RegisterHelper.registerItem(CustomItems.boots.get(i), data[0] + "Boots");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.boots.get(i).getUnlocalizedName()+".name","en_US",data[0].substring(0, 1).toUpperCase()+data[0].substring(1)+" Boots");
                }
            } else {
                LogHelper.info("Error parsing " + itemsData[i]);
            }
        }
    }
}
