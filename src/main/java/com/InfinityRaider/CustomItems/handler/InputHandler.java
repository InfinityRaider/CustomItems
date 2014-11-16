package com.InfinityRaider.CustomItems.handler;

import com.InfinityRaider.CustomItems.reference.Reference;
import com.InfinityRaider.CustomItems.utility.LogHelper;
import net.minecraft.block.material.*;

public class InputHandler {
    public static String[] getArray(String input) {
        int count = 0;
        for(int i=0;i<input.length();i++) {
            count = (input.charAt(i)==';')?(count+1):(count);
        }
        if (Reference.debug) { LogHelper.info("#blocks to add: " + count);}
        String[] array = new String[count];
        int start=0;
        int stop;
        for(int j=0;j<count;j++) {
            stop = input.indexOf(';',start+1);
            array[j] = input.substring(start,stop);
            start = stop+1;
            if(Reference.debug) {
                LogHelper.info("array["+j+"]= " +array[j]);
            }
        }
        return array;
    }

    public static String getName(String input) {
        return input.substring(0,input.indexOf('-'));
    }

    public static String getTexture(String input) {
        int start = input.indexOf('-')+1;
        int stop = input.indexOf('-',start);
        return input.substring(start,stop);
    }

    public static String[] getRecordData(String input) {
        String[] s = new String[2];
        int comma = input.indexOf(',');
        s[0] = input.substring(0,comma);
        s[1] = input.substring(comma+1);
        return s;
    }

    public static float[] getBlockData(String input) {
        float[] list = new float[4];
        int start = input.indexOf(',')+1;
        int stop;
        for(int i=0;i<list.length;i++) {
            stop = input.indexOf(',',start);
            list[i] = i==(list.length-1)?Float.parseFloat(input.substring(start))+0.00F:Float.parseFloat(input.substring(start,stop))+0.00F;
            start = stop+1;
        }
        return list;
    }

    public static float[] getToolData(String input) {
        float[] data = new float[5];
        int start = input.indexOf('-')+1;
        int stop;
        if(Reference.debug) {LogHelper.info("Getting tool data from "+input);}
        for(int i=0;i<data.length;i++) {
            stop = (i==data.length-1)?input.length():input.indexOf(',',start);
            if(Reference.debug) {LogHelper.info("data["+i+"]: "+input.substring(start,stop));}
            data[i] = Float.parseFloat(input.substring(start,stop));
            start = stop+1;
        }
        return data;
    }

    public static int[] getArmorData(String input) {
        int[] data = new int[6];
        int start = input.indexOf('-')+1;
        int stop;
        if(Reference.debug) {LogHelper.info("Getting armor data from "+input);}
        for(int i=0;i<data.length;i++) {
            stop = (i==data.length-1)?input.length():input.indexOf(',',start);
            if(Reference.debug) {LogHelper.info("data["+i+"]: "+input.substring(start,stop));}
            data[i] = Integer.parseInt(input.substring(start,stop));
            start = stop+1;
        }
        return data;
    }

    public static int[] getFluidData(String input) {
        int[] list = new int[4];
        int start = input.indexOf('-',input.indexOf('-')+1)+1;
        int stop;
        for(int i=0;i<list.length;i++) {
            stop = input.indexOf(',',start);
            if(Reference.debug) {LogHelper.info("FluidData["+i+"]: "+input.substring(start,stop));}
            list[i] =Integer.parseInt(input.substring(start,stop));
            start = stop+1;
        }
        return list;
    }
    public static boolean getFluidState(String input) {
        if(input.charAt(input.length()-1)=='g') {return true;}
        if(input.charAt(input.length()-1)=='l') {return false;}
        else {
            LogHelper.info(input.charAt(input.length()-1)+" is not a recognized state, put l for liquid, g for gas. Setting state to liquid.");
            return false;
        }
    }

    public static Material getMaterial(String input) {
        String data = input.substring(input.indexOf('-',input.indexOf('-')+1)+1,input.indexOf(','));
        if(data.equals("air")) {
            if(Reference.debug) {
            LogHelper.info("Getting material: "+data);
            }
            return Material.air;}
        if(data.equals("grass")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.grass;}
        if(data.equals("ground")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.ground;}
        if(data.equals("wood")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.wood;}
        if(data.equals("rock")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.rock;}
        if(data.equals("iron")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.iron;}
        if(data.equals("anvil")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.anvil;}
        if(data.equals("water")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.water;}
        if(data.equals("lava")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.lava;}
        if(data.equals("leaves")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.leaves;}
        if(data.equals("plants")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.plants;}
        if(data.equals("vine")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.vine;}
        if(data.equals("sponge")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.sponge;}
        if(data.equals("cloth")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.cloth;}
        if(data.equals("fire")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.fire;}
        if(data.equals("sand")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.sand;}
        if(data.equals("circuits")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.circuits;}
        if(data.equals("carpet")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.carpet;}
        if(data.equals("glass")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.glass;}
        if(data.equals("redstoneLight")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.redstoneLight;}
        if(data.equals("tnt")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.tnt;}
        if(data.equals("coral")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.coral;}
        if(data.equals("ice")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.ice;}
        if(data.equals("packedIce")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.packedIce;}
        if(data.equals("snow")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.snow;}
        if(data.equals("craftedSnow")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.craftedSnow;}
        if(data.equals("cactus")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.cactus;}
        if(data.equals("clay")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.clay;}
        if(data.equals("gourd")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.gourd;}
        if(data.equals("dragonEgg")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.dragonEgg;}
        if(data.equals("portal")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.portal;}
        if(data.equals("cake")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.cake;}
        if(data.equals("web")) {
            if(Reference.debug) {
                LogHelper.info("Getting material: "+data);
            }
            return Material.web;}
        LogHelper.info("Material "+data+" was not found, setting material to rock.");
        return Material.rock;
    }

    public static int getStackSize(String input) {
        if(Reference.debug) {LogHelper.info("Getting stacksize for "+input);}
        int firstDash = input.indexOf('-');
        return Integer.parseInt(input.substring(input.indexOf('-',firstDash+1)+1));
    }
}
