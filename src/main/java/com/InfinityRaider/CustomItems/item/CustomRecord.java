package com.InfinityRaider.CustomItems.item;

import com.InfinityRaider.CustomItems.creativetab.CustomItemsTab;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import sun.rmi.runtime.Log;

import java.util.List;

public class CustomRecord extends ItemRecord {
    protected String song;
    public CustomRecord(String song) {
        super(song);
        this.setCreativeTab(CustomItemsTab.customItemsTab);
        this.song = song;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add(this.song);
    }

    @Override
    public ResourceLocation getRecordResource(String name) {
        ResourceLocation loc = new ResourceLocation(Reference.MOD_ID.toLowerCase()+":sounds/records/"+name.substring(name.indexOf('.')+1)+".ogg");
        if(Reference.debug) {
            LogHelper.info("Getting sound for "+name);
            LogHelper.info(loc.toString());
        }
        return loc;
    }

}
