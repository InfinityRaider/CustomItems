package com.InfinityRaider.CustomItems.item;

import com.InfinityRaider.CustomItems.block.CustomFluidBlock;
import com.InfinityRaider.CustomItems.creativetab.CustomItemsTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class CustomBucket extends ItemBucket {
    public CustomBucket(CustomFluidBlock fluid) {
        super(fluid);
        this.setContainerItem(Items.bucket);
        this.setCreativeTab(CustomItemsTab.customItemsTab);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
