package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Machine;

public class Constant extends Term {
  protected Machine machine;

  public Constant(Machine machine) {
    this.machine = machine;
  }

  public boolean equals(Object obj) {
    if(obj == this)
      return true;

    if(!(obj.getClass() == this.getClass()))
      return false;

    Constant that = (Constant) obj;
    return this.machine.equals(that.machine);
  }

  public int hashCode() {
    return machine.hashCode();
  }

  public Machine eval() {
    return machine;
  }

  public String toString() {
    return machine.toString();
  }
}
