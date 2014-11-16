package com.InfinityRaider.CustomItems.handler;


import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration config;
    public static String blocks;
    public static String items;
    public static String liquids;
    public static String tools;
    public static String armor;
    public static String records;
    public static boolean debug;

    public static void init(File configFile) {
        if(config == null) {
            config = new Configuration(configFile);
        }
        loadConfiguration();
        LogHelper.info("Configuration Loaded");
    }

    public static void loadConfiguration() {
        blocks = config.getString("blocks","BLOCKS","","Put a list of blocks you wish to add with the following template: blockname-texturename-material,hardness,resistance,lightlevel,harvestlevel;"+'\n'+"Don't use semicolons, dashes or commas in the block name. Example: S:blocks=Poor Silver Ore-poorOreSilver-rock,2,3,0,2;My Planks-myPlanks-wood,5,5,7,0;Random Block 1-blockRandom1-ground,3,3,2,0;"+"\n"+"For the textures create a resourcepack and add a customitems folder, put the block textures in the blocks folder."+"\n");
        items = config.getString("items","ITEMS","","Put a list of items you wish to add with the following template here: itemname-texturename-maxstackssize;"+'\n'+"Don't use semicolons, dashes or commas in the item name. Example: S:items=Item 1-item1-1;Item 2-item2-64;"+"\n"+"For the textures create a resourcepack and add a customitems folder, put the item textures in the items folder."+"\n");
        liquids = config.getString("liquids","LIQUIDS","","Put a list of liquids you wish to add with the following template here: liquidname-texturename-luminosity,density,temperature,viscosity,gasorliquid;"+'\n'+"Don't use semicolons, dashes or commas in the liquid name. Example: S:liquids=Sulfuric Acid-sulfurAcid-0,1000,295,1500,l;This is a gas-customGas-5,-400,450,500,g;"+"\n"+"For the textures create a resourcepack and add a customitems folder, put the fluid textures in the blocks folder and the bucket textures in the items folder."+"\n"+"Texturenames for the example are sulfurAcidBucket,customGasBucket,... and for the fluids: sulfurAcid, sulfurAcid_flowing, gas, gas_flowing,..."+"\n");
        tools = config.getString("tools","TOOLS","","Put a list of tools to add with the following template: materialname-harvestlevel,uses,efficiency,damage,enchantability;"+"\n"+"Don't use semicolons, dashes or commas in the material name. Example: S:tools=crystal-3,1000,10.0,3.0,30;dirt-0,5,1.0,0.0,0;"+"\n"+"The textures go in the customitems/textures/items folder of your resourcepack, for the example they should be: crystalAxe.png, crystalPickAxe.png, crystalShovel.png, crystalHoe.png and crystalSword.png"+"\n");
        armor = config.getString("armor","ARMOR","","Put a list of armor to add with the following template: materialname-durability,helmetreduction,chestreduction,leggingreduction,bootsreduction,enchantability;"+"\n"+"Don't use semicolons, dashes or commas in the material name. Example: S:armor=titanium-45,5,10,7,5,25;"+"\n"+"The item textures go in customitems/textures/items folder of your resourcepack, for the example they should be: titaniumHelmet.png, titaniumChestplate.png, titaniumLeggings.png and titaniumBoots.png"+"\n"+"The textures for the models go into the customitems/textures/models/armor folder of your resourcepack. For the example they should be: titaniumLayer1 and titaniumLayer2"+"\n");
        records = config.getString("music disks","MUSIC_DISKS","","Put a list with music disks you wish to add with the following template here: soundfile,texture;"+'\n'+"Example: The Fratellis - Flathead,flathead;Dire Straits - Sultans of Swing,sultans;"+"\n"+"In your resourcepack, add a records folder inside the customitems folder and add the soundfiles (ogg) here. For the example: The Fratellis - Flathead.ogg, Dire Straits - Sultans of Swing.ogg"+"\n"+"WIP: doesn't work yet, don't put anything here unless you want to put missingtextures in your jukebox to play nothing."+"\n");
        debug = config.getBoolean("debug","DEBUG",false,"Set to true if you wish to output debug information to the log");
        Reference.setDebug(debug);
        if(debug) {
            LogHelper.info("blockString: "+blocks);
            LogHelper.info("itemString: "+items);
        }


        if(config.hasChanged()) {
            config.save();
        }
    }
}
