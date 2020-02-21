package com.oozinoz.firework;

import com.oozinoz.simulation.Skyrocket;

public class OozinozSkyrocket extends Skyrocket {
  private PhysicalRocket rocket;

  public OozinozSkyrocket(PhysicalRocket r) {
    super(r.getMass(0), r.getThrust(0), r.getBurnTime());
    rocket = r;
  }

  public double getMass() {
    return rocket.getMass(simTime);
  }

  public double getThrust() {
    return rocket.getThrust(simTime);
  }
}
