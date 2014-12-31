package com.InfinityRaider.CustomItems.block;

import com.InfinityRaider.CustomItems.creativetab.CustomItemsTab;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class CustomFluidBlock extends BlockFluidClassic {
    public CustomFluidBlock(Fluid fluid) {
        super(fluid, Material.water);
        if(Reference.debug) {this.setCreativeTab(CustomItemsTab.customItemsTab);}
    }
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side==0||side==1)?this.stillIcon:this.flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        if(Reference.debug) {LogHelper.info("Registering icons for: " + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));}
        stillIcon = reg.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
        flowingIcon = reg.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1)+"_flowing");
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if(world.getBlock(x,y,z).getMaterial().isLiquid()) {return false;}
        return super.canDisplace(world,x,y,z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if(world.getBlock(x,y,z).getMaterial().isLiquid()) {return false;}
        return super.displaceIfPossible(world,x,y,z);
    }
}
