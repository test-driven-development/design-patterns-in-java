package com.oozinoz.machine;

import com.oozinoz.planning.BasicPlanner;
import com.oozinoz.planning.MachinePlanner;

public class UnloadBuffer extends Machine {
  public UnloadBuffer(int id, MachineComponent parent) {
    super(id, parent);
  }

  public UnloadBuffer(int id) {
    super(id);
  }

  protected UnloadBuffer(int id, TubMediator mediator) {
    this(id, mediator, null);
  }

  public UnloadBuffer(int id, TubMediator mediator, MachineComponent parent) {
    super(id, mediator, parent);
  }

  public MachinePlanner createPlanner() {
    return new BasicPlanner(this);
  }
}
