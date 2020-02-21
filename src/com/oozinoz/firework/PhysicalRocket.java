package com.oozinoz.firework;

public class PhysicalRocket {
  private static double SPECIFIC_IMPULSE = 620; // Newtons/Kg
  private static double FUEL_DENSITY = 1800; // Kg/M**3
  private double burnArea;
  private double burnRate;
  private double initialFuelMass;
  private double totalMass;
  private double totalBurnTime;

  public PhysicalRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
    this.burnArea = burnArea;
    this.burnRate = burnRate;
    this.initialFuelMass = fuelMass;
    this.totalMass = totalMass;

    double initialFuelVolume = fuelMass / FUEL_DENSITY;
    this.totalBurnTime = initialFuelVolume / (burnRate * burnArea);
  }

  public double getMass(double t) {
    if(t > totalBurnTime)
      return totalMass - initialFuelMass;
    double burntFuelVolume = burnRate * burnArea * t;
    return totalMass - burntFuelVolume * FUEL_DENSITY;
  }

  public double getThrust(double time) {
    if(time > totalBurnTime)
      return 0;
    return FUEL_DENSITY * SPECIFIC_IMPULSE * burnRate * burnArea;
  }

  public double getBurnTime() {
    return totalBurnTime;
  }
}
