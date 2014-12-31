package com.InfinityRaider.CustomItems.fluid;

import net.minecraftforge.fluids.Fluid;

public class CustomFluid extends Fluid {
    public CustomFluid(String s, int luminosity, int density, int temperature, int viscosity, boolean isGas) {
        super(s);
        this.setLuminosity(luminosity);
        this.setDensity(density);
        this.setTemperature(temperature);
        this.setViscosity(viscosity);
        this.setGaseous(isGas);
    }
}
