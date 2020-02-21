package com.oozinoz.planning;

import com.oozinoz.machine.StarPress;

public class StarPressPlanner extends MachinePlanner {
  public StarPressPlanner(StarPress machine) {
    super(machine);
  }

  public java.util.Date getAvailable() {
    // just return the current time, in this example
    return new java.util.Date();
  }
}
