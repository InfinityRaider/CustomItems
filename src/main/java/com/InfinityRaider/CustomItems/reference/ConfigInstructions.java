package com.InfinityRaider.CustomItems.reference;

public final class ConfigInstructions {
    public static final String blockInstructions =
                    "#Put a list of blocks you wish to add with the following template: blockname,texturename,material,tool,hardness,resistance,lightlevel,harvestlevel\n" +
                    "#Each line represents one entry\n" +
                    "#Don't use semicolons or commas in the block name. Examples (indentations are not needed):\n"+
                    "#   Poor Silver Ore,poorOreSilver,rock,pickaxe,2,3,0,2\n"+
                    "#   My Planks,myPlanks,wood,axe,5,5,7,0\n"+"" +
                    "#   Random Block 1,blockRandom1,ground,shovel,3,3,2,0\n" +
                    "#For the textures, create a resourcepack and add a customitems folder, put the block textures in the blocks folder.";

    public static final String itemInstructions =
                    "#Put a list of items you wish to add with the following template here: itemname,texturename,maxstackssize\n" +
                    "#Each line represents one entry\n" +
                    "#Don't use semicolons or commas in the item name. Example(indentations are not needed):\n"+
                    "#   Item 1,item1,1\n"+
                    "#   Item 2,item2,64\n"+
                    "#For the textures create a resourcepack and add a customitems folder, put the item textures in the items folder.";

    public static final String liquidInstructions =
                    "#Put a list of liquids you wish to add with the following template here: liquidname,texturename,luminosity,density,temperature,viscosity,gasorliquid\n"+
                    "#Each line represents one entry\n" +
                    "#Don't use semicolons or commas in the liquid name. Example (indentations are not needed):\n"+
                    "#   Sulfuric Acid,sulfurAcid,0,1000,295,1500,l\n"+
                    "#   This is a gas-customGas-5,-400,450,500,g\n" +
                    "#For the textures create a resourcepack and add a customitems folder, put the fluid textures in the blocks folder and the bucket textures in the items folder.\n"+
                    "#Texture names for the example are sulfurAcidBucket and customGasBucket for the buckets and sulfurAcid, sulfurAcid_flowing, gas, gas_flowing for the fluids.";

    public static final String toolInstructions =
                    "#Put a list of tools to add with the following template: type,materialname,harvestlevel,uses,efficiency,damage,enchantability\n" +
                    "#Each line represents one entry. Type is: sword, axe, pickaxe, shovel or hoe, you can type all if you want all the tools of that material.\n" +
                    "#Don't use semicolons or commas in the material name. efficiency and damage do not have to be integers. Example (indentations are not needed):\n"+
                    "#   pickaxe,crystal,3,1000,10.0,3.0,30\n"+
                    "#   all,dirt,0,5,1.0,0.0,0\n"+
                    "#The textures go in the customitems/textures/items folder of your resourcepack, and name them like this material_type.png\n"+
                    "#For the example they should be: crystal_pickaxe.png and dirt_sword.png, dirt_axe.png, dirt_pickaxe.png, dirt_shovel.png, dirt_hoe.png";

    public static final String armorInstructions =
                    "#Put a list of armor to add with the following template: materialname,durability,helmetreduction,chestreduction,leggingreduction,bootsreduction,enchantability\n"+
                    "#Each line represents one entry. If you do not want a certain armorpiece of that material, define the reduction negative.\n" +
                    "#Don't use semicolons or commas in the material name. Example(indentations are not needed):\n" +
                    "#   titanium,45,5,10,7,5,25\n"+
                    "#The item textures go in customitems/textures/items folder of your resourcepack, for the example they should be: titaniumHelmet.png, titaniumChestplate.png, titaniumLegs.png and titaniumBoots.png\n"+
                    "#The textures for the models go into the customitems/textures/models/armor folder of your resourcepack. For the example they should be: titaniumLayer1 and titaniumLayer2";

    public static final String recordInstructions =
                    "#Put a list with music disks you wish to add with the following template here: soundfile,texture\n"+
                    "#Each line represents one entry. Example (indentations are not needed):\n" +
                    "#   The Fratellis - Flathead,flathead\n"+
                    "#   Dire Straits - Sultans of Swing,sultans\n"+
                    "#In your resourcepack, add a records folder inside the customitems folder and add the soundfiles (ogg) here.\n"+
                    "#For the example: The Fratellis - Flathead.ogg and Dire Straits - Sultans of Swing.ogg";

}
