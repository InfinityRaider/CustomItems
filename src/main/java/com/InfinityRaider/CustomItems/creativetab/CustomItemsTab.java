package com.InfinityRaider.CustomItems.creativetab;

import com.InfinityRaider.CustomItems.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CustomItemsTab {
    public static final CreativeTabs customItemsTab = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Items.emerald;
        }
    };
}
