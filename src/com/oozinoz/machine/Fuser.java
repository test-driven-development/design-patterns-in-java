package com.oozinoz.machine;

public class Fuser extends Machine {
  public Fuser(int id, MachineComponent parent) {
    super(id, parent);
  }

  public Fuser(int id) {
    super(id);
  }

  public Fuser(int id, TubMediator mediator) {
    this(id, mediator, null);
  }

  public Fuser(int id, TubMediator mediator, MachineComponent parent) {
    super(id, mediator, parent);
  }
}
