package com.InfinityRaider.CustomItems;

import com.InfinityRaider.CustomItems.block.CustomBlock;
import com.InfinityRaider.CustomItems.block.CustomFluidBlock;
import com.InfinityRaider.CustomItems.fluid.CustomFluid;
import com.InfinityRaider.CustomItems.handler.FluidTextureEventHandler;
import com.InfinityRaider.CustomItems.init.*;
import com.InfinityRaider.CustomItems.item.CustomArmor;
import com.InfinityRaider.CustomItems.item.CustomBucket;
import com.InfinityRaider.CustomItems.item.CustomItem;
import com.InfinityRaider.CustomItems.item.CustomRecord;
import com.InfinityRaider.CustomItems.item.tools.*;
import com.InfinityRaider.CustomItems.reference.ConfigInstructions;
import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.IOHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.ArrayList;

@Mod(modid= Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.VERSION)
public class CustomItems {
    //mod instance
    @Mod.Instance(Reference.MOD_ID)
    public static CustomItems instance;
    //config directory
    public static String configDir;
    //items and blocks
    public static ArrayList<CustomBlock> blocks = new ArrayList<CustomBlock>();
    public static ArrayList<CustomItem> items = new ArrayList<CustomItem>();
    public static ArrayList<CustomFluid> fluids = new ArrayList<CustomFluid>();
    public static ArrayList<CustomFluidBlock> fluidBlocks = new ArrayList<CustomFluidBlock>();
    public static ArrayList<CustomBucket> buckets = new ArrayList<CustomBucket>();
    public static ArrayList<Item.ToolMaterial> toolMaterials = new ArrayList<Item.ToolMaterial>();
    public static ArrayList<CustomAxe> axes = new ArrayList<CustomAxe>();
    public static ArrayList<CustomHoe> hoes = new ArrayList<CustomHoe>();
    public static ArrayList<CustomPickaxe> pickaxes = new ArrayList<CustomPickaxe>();
    public static ArrayList<CustomShovel> shovels = new ArrayList<CustomShovel>();
    public static ArrayList<CustomSword> swords = new ArrayList<CustomSword>();
    public static ArrayList<ItemArmor.ArmorMaterial> armorMaterials = new ArrayList<ItemArmor.ArmorMaterial>();
    public static ArrayList<CustomArmor> helmets = new ArrayList<CustomArmor>();
    public static ArrayList<CustomArmor> chestplates = new ArrayList<CustomArmor>();
    public static ArrayList<CustomArmor> leggings = new ArrayList<CustomArmor>();
    public static ArrayList<CustomArmor> boots = new ArrayList<CustomArmor>();
    public static ArrayList<CustomRecord> records = new ArrayList<CustomRecord>();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //set up config directory
        configDir = event.getModConfigurationDirectory().toString()+'/'+Reference.MOD_ID.toLowerCase()+'/';
        new Configuration(new File(configDir,"Configuration.cfg"));
        //register event handler
        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            MinecraftForge.EVENT_BUS.register(new FluidTextureEventHandler());
        }
        //initialize blocks
        ModBlocks.init(IOHelper.getLinesArrayFromData(IOHelper.readOrWrite(configDir, "Blocks", ConfigInstructions.blockInstructions)));
        //initialize items
        ModItems.init(IOHelper.getLinesArrayFromData(IOHelper.readOrWrite(configDir, "Items", ConfigInstructions.itemInstructions)));
        //initialize fluids
        ModFluids.init(IOHelper.getLinesArrayFromData(IOHelper.readOrWrite(configDir, "Fluids", ConfigInstructions.liquidInstructions)));
        //initialize tools
        ModTools.init(IOHelper.getLinesArrayFromData(IOHelper.readOrWrite(configDir, "Tools", ConfigInstructions.toolInstructions)));
        //initialize armor
        ModArmor.init(IOHelper.getLinesArrayFromData(IOHelper.readOrWrite(configDir, "Tools", ConfigInstructions.armorInstructions)));
        //initialize records
        ModRecords.init(IOHelper.getLinesArrayFromData(IOHelper.readOrWrite(configDir, "Records", ConfigInstructions.recordInstructions)));
    }
}
