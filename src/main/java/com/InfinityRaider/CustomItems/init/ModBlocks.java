package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.block.CustomBlock;
import com.InfinityRaider.CustomItems.handler.ConfigurationHandler;
import com.InfinityRaider.CustomItems.handler.InputHandler;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static Block[] blocks;
    public static void init() {
        String blocksData[] = InputHandler.getArray(ConfigurationHandler.blocks);
        blocks = new Block[blocksData.length];
        for(int i=0;i<blocksData.length;i++) {
            if(Reference.debug) {LogHelper.info("Adding block: "+blocksData[i]);}
            String unlocalizedName = InputHandler.getTexture(blocksData[i]);
            blocks[i] = new CustomBlock(InputHandler.getMaterial(blocksData[i]));
            float[] data = InputHandler.getBlockData(blocksData[i]);
            blocks[i].setHardness(data[0]);
            blocks[i].setResistance(data[1]);
            blocks[i].setLightLevel(data[2]);
            if(Reference.debug) {LogHelper.info("Setting mining level for "+unlocalizedName+" to "+(int) data[3]);}
            if(blocks[i].getMaterial()== Material.rock) {blocks[i].setHarvestLevel("pickaxe",(int) data[3]);}
            else {blocks[i].setHarvestLevel(blocks[i].getHarvestTool(0),(int) data[3]);}
            GameRegistry.registerBlock(blocks[i],unlocalizedName);
            blocks[i].setBlockName(Reference.MOD_ID.toLowerCase()+":"+unlocalizedName);
            LanguageRegistry.instance().addStringLocalization(blocks[i].getUnlocalizedName()+".name","en_US", InputHandler.getName(blocksData[i]));
        }
    }
}
