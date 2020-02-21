package com.oozinoz.planning;

import com.oozinoz.machine.Machine;

import java.util.Date;

public abstract class MachinePlanner {
  protected Machine machine;

  public MachinePlanner(Machine m) {
    machine = m;
  }

  public abstract Date getAvailable();
}
