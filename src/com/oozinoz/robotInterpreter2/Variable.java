package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Machine;

public class Variable extends Term {
  protected String name;
  protected Term value;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void assign(Term term) {
    this.value = term;
  }

  public boolean equals(Object o) {
    if(o == this)
      return true;

    if(!(o instanceof Variable))
      return false;

    Variable v = (Variable) o;

    return name.equals(v.name);
  }

  public int hashCode() {
    return name.hashCode();
  }

  public Machine eval() {
    return value.eval();
  }

  public String toString() {
    return name + ": " + value;
  }
}
