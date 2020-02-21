package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Machine;

public class HasMaterial extends Term {
  protected Term term;

  public HasMaterial(Term term) {
    this.term = term;
  }

  public Machine eval() {
    Machine m = term.eval();
    return m.hasMaterial() ? m : null;
  }
}
