package com.oozinoz.machine;

import com.oozinoz.planning.MachinePlanner;
import com.oozinoz.planning.StarPressPlanner;

public class StarPress extends Machine {
  public StarPress(int id, MachineComponent parent) {
    super(id, parent);
  }

  public StarPress(int id) {
    super(id);
  }

  protected StarPress(int id, TubMediator mediator) {
    this(id, mediator, null);
  }

  public StarPress(int id, TubMediator mediator, MachineComponent parent) {
    super(id, mediator, parent);
  }

  public MachinePlanner createPlanner() {
    return new StarPressPlanner(this);
  }
}
