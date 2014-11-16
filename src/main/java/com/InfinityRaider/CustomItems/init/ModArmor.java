package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.handler.ConfigurationHandler;
import com.InfinityRaider.CustomItems.handler.InputHandler;
import com.InfinityRaider.CustomItems.item.CustomArmor;
import com.InfinityRaider.CustomItems.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Arrays;

public class ModArmor {
    public static ItemArmor[] helmets;
    public static ItemArmor[] chestplates;
    public static ItemArmor[] leggings;
    public static ItemArmor[] boots;
    public static void init() {
        String[] armorData = InputHandler.getArray(ConfigurationHandler.armor);
        ItemArmor.ArmorMaterial[] materials = new ItemArmor.ArmorMaterial[armorData.length];
        int[] helmetId = new int[armorData.length];
        int[] chestplateId = new int[armorData.length];
        int[] leggingsId = new int[armorData.length];
        int[] bootsId = new int[armorData.length];
        helmets = new CustomArmor[armorData.length];
        chestplates = new CustomArmor[armorData.length];
        leggings = new CustomArmor[armorData.length];
        boots = new CustomArmor[armorData.length];
        for(int i=0;i<armorData.length;i++) {
            String name = InputHandler.getName(armorData[i]);
            int[] data = InputHandler.getArmorData(armorData[i]);
            materials[i] = EnumHelper.addArmorMaterial(name,data[0], Arrays.copyOfRange(data,1,5),data[5]);
            //helmets
            helmets[i] = new CustomArmor(materials[i],helmetId[i],0,name);
            GameRegistry.registerItem(helmets[i],name+"Helmet");
            helmets[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Helmet");
            LanguageRegistry.instance().addStringLocalization(helmets[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Helmet");
            //chestplates
            chestplates[i] = new CustomArmor(materials[i],chestplateId[i],1,name);
            GameRegistry.registerItem(chestplates[i],name+"Chestplate");
            chestplates[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Chestplate");
            LanguageRegistry.instance().addStringLocalization(chestplates[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Chestplate");
            //leggings
            leggings[i] = new CustomArmor(materials[i],leggingsId[i],2,name);
            GameRegistry.registerItem(leggings[i],name+"Leggings");
            leggings[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Leggings");
            LanguageRegistry.instance().addStringLocalization(leggings[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Leggings");
            //boots
            boots[i] = new CustomArmor(materials[i],bootsId[i],3,name);
            GameRegistry.registerItem(boots[i],name+"Boots");
            boots[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Boots");
            LanguageRegistry.instance().addStringLocalization(boots[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Boots");
        }
    }
}
