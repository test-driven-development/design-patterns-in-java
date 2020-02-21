package com.oozinoz.machine;

import com.oozinoz.planning.MachinePlanner;
import com.oozinoz.planning.ShellPlanner;

public class ShellAssembler extends Machine {
  public ShellAssembler(int id, MachineComponent parent) {
    super(id, parent);
  }

  public ShellAssembler(int id) {
    super(id);
  }

  protected ShellAssembler(int id, TubMediator mediator) {
    this(id, mediator, null);
  }

  public ShellAssembler(int id, TubMediator mediator, MachineComponent parent) {
    super(id, mediator, parent);
  }

  public MachinePlanner createPlanner() {
    return new ShellPlanner(this);
  }
}
