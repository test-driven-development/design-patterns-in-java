package com.oozinoz.planning;

import com.oozinoz.machine.Machine;

import java.util.Date;

public class BasicPlanner extends MachinePlanner {
  public BasicPlanner(Machine m) {
    super(m);
  }

  public Date getAvailable() {
    return new Date();
  }
}
