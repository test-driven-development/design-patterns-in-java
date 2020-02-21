package com.oozinoz.simulation;

public class Skyrocket {
  protected double simTime;
  private double mass;
  private double thrust;
  private double burnTime;

  public Skyrocket(double mass, double thrust, double burnTime) {
    this.mass = mass;
    this.thrust = thrust;
    this.burnTime = burnTime;
  }

  public double getMass() {
    if(simTime > burnTime)
      return 0;
    return mass * (1 - (simTime / burnTime));
  }

  public double getThrust() {
    if(simTime > burnTime)
      return 0;
    return thrust;
  }

  public void setSimTime(double t) {
    simTime = t;
  }
}
