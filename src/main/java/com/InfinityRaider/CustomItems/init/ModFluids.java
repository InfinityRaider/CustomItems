package com.InfinityRaider.CustomItems.init;

import com.InfinityRaider.CustomItems.block.CustomFluidBlock;

import com.InfinityRaider.CustomItems.fluid.CustomFluid;
import com.InfinityRaider.CustomItems.handler.BucketHandler;
import com.InfinityRaider.CustomItems.handler.ConfigurationHandler;
import com.InfinityRaider.CustomItems.handler.InputHandler;
import com.InfinityRaider.CustomItems.item.CustomBucket;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModFluids {
    public static CustomFluid[] fluids;
    public static CustomFluidBlock[] fluidBlocks;
    public static CustomBucket[] buckets;
    public static void init() {
        String[] fluidsArray = InputHandler.getArray(ConfigurationHandler.liquids);
        int l = fluidsArray.length;
        fluids = new CustomFluid[l];
        fluidBlocks = new CustomFluidBlock[l];
        buckets = new CustomBucket[l];
        for(int i=0;i<fluidsArray.length;i++) {
            String localizedName = InputHandler.getName(fluidsArray[i]);
            String fluidName = InputHandler.getTexture(fluidsArray[i]);
            int[] fluidData = InputHandler.getFluidData(fluidsArray[i]);
            boolean gas = InputHandler.getFluidState(fluidsArray[i]);
            //register fluid
            if(Reference.debug) {LogHelper.info("Registering fluid: "+fluidName);}
            fluids[i] = new CustomFluid(fluidName);
            fluids[i].setLuminosity(fluidData[0]);
            fluids[i].setDensity(fluidData[1]);
            fluids[i].setTemperature(fluidData[2]);
            fluids[i].setViscosity(fluidData[3]);
            fluids[i].setGaseous(gas);
            FluidRegistry.registerFluid(fluids[i]);
            //register block
            fluidBlocks[i] = new CustomFluidBlock(fluids[i], Material.water);
            fluidBlocks[i].setBlockName(Reference.MOD_ID.toLowerCase()+":"+fluidName);
            GameRegistry.registerBlock(fluidBlocks[i], Reference.MOD_ID.toLowerCase() + ":" + fluidName);
            fluids[i].setUnlocalizedName(fluidBlocks[i].getUnlocalizedName().substring(fluidBlocks[i].getUnlocalizedName().indexOf(":") + 1));
            LanguageRegistry.instance().addStringLocalization(fluidBlocks[i].getUnlocalizedName()+".name","en_US",localizedName);
            LanguageRegistry.instance().addStringLocalization(fluids[i].getUnlocalizedName(),"en_US",localizedName);
            fluids[i].setBlock(fluidBlocks[i]);
            fluids[i].setIcons(fluidBlocks[i]);
            //register bucket
            buckets[i] = new CustomBucket(fluidBlocks[i]);
            buckets[i].setUnlocalizedName(Reference.MOD_ID.toLowerCase()+":"+fluidName+"Bucket");
            buckets[i].setContainerItem(Items.bucket);
            GameRegistry.registerItem(buckets[i],fluidName+"Bucket");
            if(Reference.debug) {LogHelper.info("Adding bucket for: "+FluidRegistry.getFluidStack(fluids[i].getName(),FluidContainerRegistry.BUCKET_VOLUME));}
            FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluids[i].getName(),FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(buckets[i]),new ItemStack(Items.bucket));
            LanguageRegistry.instance().addStringLocalization(buckets[i].getUnlocalizedName()+".name","en_US",localizedName+" Bucket");
            BucketHandler.INSTANCE.buckets.put(fluidBlocks[i], buckets[i]);
            MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        }
    }
}
