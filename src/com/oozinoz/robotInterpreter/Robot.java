package com.oozinoz.robotInterpreter;

import com.oozinoz.machine.Bin;
import com.oozinoz.machine.Machine;

public class Robot {
  public static final Robot singleton = new Robot();

  private Robot() {
  }

  public void carry(Machine fromMachine, Machine toMachine) {
    System.out.println("Robot carrying from " + fromMachine + " to " + toMachine);
    Bin b = fromMachine.unload();
    if(b != null)
      toMachine.load(b);
  }
}
