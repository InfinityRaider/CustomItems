package com.InfinityRaider.CustomItems.block;

import com.InfinityRaider.CustomItems.creativetab.CustomItemsTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class CustomBlock extends Block {
    public CustomBlock() {
        this(Material.rock);
    }
    public CustomBlock(Material material) {
        super(material);
        this.setCreativeTab(CustomItemsTab.customItemsTab);
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }
}
