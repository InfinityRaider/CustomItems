package com.InfinityRaider.CustomItems.item;

import com.InfinityRaider.CustomItems.creativetab.CustomItemsTab;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CustomArmor extends ItemArmor {
    protected int type;
    protected String name = "";
    public CustomArmor(ArmorMaterial mat,int id,int type,String name) {
        super(mat,id,type);
        this.setCreativeTab(CustomItemsTab.customItemsTab);
        this.type=type;
        this.name=name;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if(stack.getItem() instanceof CustomArmor) {
            String path = Reference.MOD_ID.toLowerCase() + ":textures/models/armor/" + this.name + "Layer";
            String end = slot == 2 ? "2.png" : "1.png";
            return path + end;
        }
        else {
            return null;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }
}
