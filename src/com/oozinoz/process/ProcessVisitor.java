package com.oozinoz.process;

public interface ProcessVisitor {
  void visit(ProcessAlternation a);

  void visit(ProcessSequence s);

  void visit(ProcessStep s);
}
