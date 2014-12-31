package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.CustomItems;
import com.InfinityRaider.CustomItems.block.CustomFluidBlock;

import com.InfinityRaider.CustomItems.fluid.CustomFluid;
import com.InfinityRaider.CustomItems.item.CustomBucket;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.IOHelper;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import com.InfinityRaider.CustomItems.utility.RegisterHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fluids.FluidRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModFluids {
    public static void init(String[] fluidsData) {
        for(int i=0;i<fluidsData.length;i++) {
            String[] data = IOHelper.getData(fluidsData[i]);
            //{liquidname,texturename,luminosity,density,temperature,viscosity,gasorliquid}
            if(data.length==7) {
                CustomItems.fluids.add(new CustomFluid(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6].equals("g")));
                CustomItems.fluidBlocks.add(new CustomFluidBlock(CustomItems.fluids.get(i)));
                CustomItems.fluidBlocks.get(i).setBlockName(Reference.MOD_ID.toLowerCase() + ":" + data[1]);
                CustomItems.fluids.get(i).setBlock(CustomItems.fluidBlocks.get(i));
                CustomItems.buckets.add(new CustomBucket(CustomItems.fluidBlocks.get(i)));
                CustomItems.buckets.get(i).setUnlocalizedName(Reference.MOD_ID.toLowerCase() + ":" + data[1] + "Bucket");
                FluidRegistry.registerFluid(CustomItems.fluids.get(i));
                RegisterHelper.registerBlock(CustomItems.fluidBlocks.get(i), Reference.MOD_ID.toLowerCase() + ":" + data[1]);
                RegisterHelper.registerItem(CustomItems.buckets.get(i), data[1]+"Bucket");
                LanguageRegistry.instance().addStringLocalization(CustomItems.fluidBlocks.get(i).getUnlocalizedName()+".name","en_US",data[0]);
                LanguageRegistry.instance().addStringLocalization(CustomItems.fluids.get(i).getUnlocalizedName(),"en_US",data[0]);
                LanguageRegistry.instance().addStringLocalization(CustomItems.buckets.get(i).getUnlocalizedName()+".name","en_US",data[0]+" Bucket");
            }
            else {
                LogHelper.info("Error parsing "+fluidsData[i]);
            }
        }
    }
}
