package com.oozinoz.robotInterpreter;

import com.oozinoz.machine.Machine;

public class CarryCommand extends Command {
  protected Machine fromMachine;

  protected Machine toMachine;

  public CarryCommand(Machine fromMachine, Machine toMachine) {
    this.fromMachine = fromMachine;
    this.toMachine = toMachine;
  }

  public void execute() {
    Robot.singleton.carry(fromMachine, toMachine);
  }
}
