package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Machine;

public class ShutDownCommand extends Command {
  protected Term term;

  public ShutDownCommand(Term term) {
    this.term = term;
  }

  public void execute() {
    Machine m = term.eval();
    m.shutdown();
  }
}
