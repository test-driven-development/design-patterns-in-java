package com.oozinoz.firework;

import com.oozinoz.simulation.RocketSim;

public class OozinozRocket extends PhysicalRocket implements RocketSim {
  private double time = 0;

  public OozinozRocket(
    double burnArea,
    double burnRate,
    double fuelMass,
    double totalMass) {
    super(burnArea, burnRate, fuelMass, totalMass);
  }

  public double getMass() {
    return getMass(this.time);
  }

  public double getThrust() {
    return getThrust(this.time);
  }

  public void setSimTime(double time) {
    this.time = time;
  }
}
