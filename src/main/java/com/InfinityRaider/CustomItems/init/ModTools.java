package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.handler.ConfigurationHandler;
import com.InfinityRaider.CustomItems.handler.InputHandler;
import com.InfinityRaider.CustomItems.item.tools.*;
import com.InfinityRaider.CustomItems.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

public class ModTools {
    public static ItemSword[] swords;
    public static ItemPickaxe[] pickaxes;
    public static ItemAxe[] axes;
    public static ItemSpade[] shovels;
    public static ItemHoe[] hoes;
    public static void init() {
        String[] toolsData = InputHandler.getArray(ConfigurationHandler.tools);
        Item.ToolMaterial[] materials = new Item.ToolMaterial[toolsData.length];
        swords = new CustomSword[toolsData.length];
        pickaxes = new CustomPickaxe[toolsData.length];
        axes = new CustomAxe[toolsData.length];
        shovels = new CustomShovel[toolsData.length];
        hoes = new CustomHoe[toolsData.length];
        for(int i=0;i<toolsData.length;i++) {
            String name = InputHandler.getName(toolsData[i]);
            float[] data = InputHandler.getToolData(toolsData[i]);
            materials[i] = EnumHelper.addToolMaterial(name,(int) Math.floor(data[0]),(int) Math.floor(data[1]),data[2],data[3],(int) Math.floor(data[4]));
            //swords
            swords[i]= new CustomSword(materials[i]);
            GameRegistry.registerItem(swords[i],name+"Sword");
            swords[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Sword");
            LanguageRegistry.instance().addStringLocalization(swords[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Sword");
            //pickaxes
            pickaxes[i]= new CustomPickaxe(materials[i]);
            GameRegistry.registerItem(pickaxes[i],name+"Pickaxe");
            pickaxes[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Pickaxe");
            LanguageRegistry.instance().addStringLocalization(pickaxes[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Pickaxe");
            //axes
            axes[i] = new CustomAxe(materials[i]);
            GameRegistry.registerItem(axes[i],name+"Axe");
            axes[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Axe");
            LanguageRegistry.instance().addStringLocalization(axes[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Axe");
            //shovels
            shovels[i] = new CustomShovel(materials[i]);
            GameRegistry.registerItem(shovels[i],name+"Shovel");
            shovels[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Shovel");
            LanguageRegistry.instance().addStringLocalization(shovels[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Shovel");
            //hoes
            hoes[i] = new CustomHoe(materials[i]);
            GameRegistry.registerItem(hoes[i],name+"Hoe");
            hoes[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+name+"Hoe");
            LanguageRegistry.instance().addStringLocalization(hoes[i].getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1)+" Hoe");
        }
    }
}
