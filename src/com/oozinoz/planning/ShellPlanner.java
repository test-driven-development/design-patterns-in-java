package com.oozinoz.planning;

import com.oozinoz.machine.Machine;

import java.util.Date;

public class ShellPlanner extends MachinePlanner {
  public ShellPlanner(Machine m) {
    super(m);
  }

  public Date getAvailable() {
    return new Date();
  }
}
