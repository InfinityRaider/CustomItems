package com.InfinityRaider.CustomItems.utility;

import com.InfinityRaider.CustomItems.reference.Reference;
import net.minecraft.block.material.Material;

import java.io.*;
import java.util.ArrayList;

public class IOHelper {
    //reads and writes text files
    public static String readOrWrite(String directory, String fileName, String defaultData) {
        return readOrWrite(directory, fileName, defaultData, false);
    }

    public static String readOrWrite(String directory, String fileName, String defaultData, boolean reset) {
        LogHelper.info("Reading/Writing "+directory+fileName);
        File file = new File(directory, fileName+".txt");
        if(file.exists() && !file.isDirectory() && !reset) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] input = new byte[(int) file.length()];
                try {
                    inputStream.read(input);
                    inputStream.close();
                    return new String(input, "UTF-8");
                } catch (IOException e) {
                    LogHelper.info("Caught IOException when reading "+fileName+".txt");
                }
            } catch(FileNotFoundException e) {
                LogHelper.info("Caught IOException when reading "+fileName+".txt");
            }
        }
        else {
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                try {
                    writer.write(defaultData);
                    writer.close();
                    return defaultData;
                }
                catch(IOException e) {
                    LogHelper.info("Caught IOException when writing "+fileName+".txt");
                }
            }
            catch(IOException e) {
                LogHelper.info("Caught IOException when writing "+fileName+".txt");
            }
        }
        return null;
    }

    //turns the raw data string into an array (each array element is a line from the string)
    public static String[] getLinesArrayFromData(String input) {
        int count = 0;
        String unprocessed = input;
        for (int i=0;i<unprocessed.length();i++) {
            if (unprocessed.charAt(i) == '\n') {
                count++;
            }
        }
        ArrayList<String> data = new ArrayList<String>();
        if (unprocessed.length()>0) {
            for (int i=0;i<count;i++) {
                String line = (unprocessed.substring(0,unprocessed.indexOf('\n'))).trim();
                LogHelper.info("Line: "+line);
                if (line.length() > 0 && line.charAt(0) != '#') {
                    data.add(line);
                }
                unprocessed = unprocessed.substring(unprocessed.indexOf('\n')+1);
            }
        }
        if (unprocessed.length()>0 && unprocessed.charAt(0)!='#') {
            data.add(unprocessed);
        }
        return data.toArray(new String[data.size()]);
    }

    //splits a comma seperated string into an array
    public static String[] getData(String input) {
        String data = input;
        int count = 0;
        for(int i=0;i<data.length();i++) {
            count=(data.charAt(i)==',')?count+1:count;
        }
        ArrayList<String> output = new ArrayList<String>();
        for(int i=0;i<count;i++) {
            int stop=data.indexOf(',');
            output.add(data.substring(0,stop));
            data=data.substring(stop+1);
        }
        output.add(data);
        return output.toArray(new String[output.size()]);
    }

    //get material from a string
    public static Material getMaterial(String data) {
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
}
