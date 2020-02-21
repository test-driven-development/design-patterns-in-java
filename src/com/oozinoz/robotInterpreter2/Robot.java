package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Bin;
import com.oozinoz.machine.Machine;

public class Robot {
  public static final Robot singleton = new Robot();

  private Robot() {
  }

  public void carry(Machine m1, Machine m2) {
    System.out.println("Robot carrying from " + m1 + " to " + m2);
    Bin b = m1.unload();
    if(b != null)
      m2.load(b);
  }
}
