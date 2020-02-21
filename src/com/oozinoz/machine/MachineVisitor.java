package com.oozinoz.machine;

public interface MachineVisitor {
  void visit(Machine m);

  void visit(MachineComposite mc);
}
