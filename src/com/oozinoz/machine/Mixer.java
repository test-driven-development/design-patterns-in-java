package com.oozinoz.machine;

public class Mixer extends Machine {
  public Mixer(int id, MachineComponent parent) {
    super(id, parent);
  }

  public Mixer(int id) {
    super(id);
  }

  protected Mixer(int id, TubMediator mediator) {
    this(id, mediator, null);
  }

  public Mixer(int id, TubMediator mediator, MachineComponent parent) {
    super(id, mediator, parent);
  }
}
