package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.CustomItems;
import com.InfinityRaider.CustomItems.item.tools.*;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.IOHelper;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import com.InfinityRaider.CustomItems.utility.RegisterHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.util.EnumHelper;

public class ModTools {
    public static void init(String[] toolsData) {
        for(int i=0;i<toolsData.length;i++) {
            String[] data = IOHelper.getData(toolsData[i]);
            //{type,materialname,harvestlevel,uses,efficiency,damage,enchantability}
            if(data.length==7) {
                CustomItems.toolMaterials.add(EnumHelper.addToolMaterial(data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),Float.parseFloat(data[4]),Float.parseFloat(data[5]),Integer.parseInt(data[6])));
                if(data[0].equalsIgnoreCase("all") || data[0].equalsIgnoreCase("axe")) {
                    CustomItems.axes.add(new CustomAxe(CustomItems.toolMaterials.get(i)));
                    CustomItems.axes.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[1] + "Axe");
                    RegisterHelper.registerItem(CustomItems.axes.get(i), data[1]+"Axe");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.axes.get(i).getUnlocalizedName()+".name","en_US",data[1].substring(0, 1).toUpperCase()+data[1].substring(1)+" Axe");
                }
                if(data[0].equalsIgnoreCase("all") || data[0].equalsIgnoreCase("pickaxe")) {
                    CustomItems.pickaxes.add(new CustomPickaxe(CustomItems.toolMaterials.get(i)));
                    CustomItems.pickaxes.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[1] + "Pickaxe");
                    RegisterHelper.registerItem(CustomItems.pickaxes.get(i), data[1]+"Pickaxe");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.pickaxes.get(i).getUnlocalizedName()+".name","en_US",data[1].substring(0, 1).toUpperCase()+data[1].substring(1)+" Pickaxe");
                }
                if(data[0].equalsIgnoreCase("all") || data[0].equalsIgnoreCase("shovel")) {
                    CustomItems.shovels.add(new CustomShovel(CustomItems.toolMaterials.get(i)));
                    CustomItems.shovels.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[1] + "Shovel");
                    RegisterHelper.registerItem(CustomItems.shovels.get(i), data[1]+"Shovel");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.shovels.get(i).getUnlocalizedName()+".name","en_US",data[1].substring(0, 1).toUpperCase()+data[1].substring(1)+" Shovel");
                }
                if(data[0].equalsIgnoreCase("all") || data[0].equalsIgnoreCase("hoe")) {
                    CustomItems.hoes.add(new CustomHoe(CustomItems.toolMaterials.get(i)));
                    CustomItems.hoes.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[1] + "Hoe");
                    RegisterHelper.registerItem(CustomItems.hoes.get(i), data[1]+"Hoe");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.hoes.get(i).getUnlocalizedName()+".name","en_US",data[1].substring(0, 1).toUpperCase()+data[1].substring(1)+" Hoe");
                }
                if(data[0].equalsIgnoreCase("all") || data[0].equalsIgnoreCase("sword")) {
                    CustomItems.swords.add(new CustomSword(CustomItems.toolMaterials.get(i)));
                    CustomItems.swords.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[1] + "Sword");
                    RegisterHelper.registerItem(CustomItems.swords.get(i), data[1]+"Sword");
                    LanguageRegistry.instance().addStringLocalization(CustomItems.swords.get(i).getUnlocalizedName()+".name","en_US",data[1].substring(0, 1).toUpperCase()+data[1].substring(1)+" Sword");
                }
            }
            else {
                LogHelper.info("Error parsing " + toolsData[i]);
            }
        }
    }
}
