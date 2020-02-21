package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Machine;

public class Equals extends Term {
  protected Term term1;
  protected Term term2;

  public Equals(Term term1, Term term2) {
    this.term1 = term1;
    this.term2 = term2;
  }

  public Machine eval() {
    Machine m1 = term1.eval();
    Machine m2 = term2.eval();
    return m1.equals(m2) ? m1 : null;
  }
}
