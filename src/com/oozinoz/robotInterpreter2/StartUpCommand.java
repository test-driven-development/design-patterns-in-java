package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Machine;

public class StartUpCommand extends Command {
  protected Term term;

  public StartUpCommand(Term term) {
    this.term = term;
  }

  public void execute() {
    Machine m = term.eval();
    m.startup();
  }
}
