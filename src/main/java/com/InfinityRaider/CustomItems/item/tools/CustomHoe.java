package com.InfinityRaider.CustomItems.item.tools;

import com.InfinityRaider.CustomItems.creativetab.CustomItemsTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;

public class CustomHoe extends ItemHoe {
    public CustomHoe(ToolMaterial mat) {
        super(mat);
        this.setCreativeTab(CustomItemsTab.customItemsTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }
}
