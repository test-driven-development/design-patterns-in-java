package com.oozinoz.process;

import java.util.List;

public class ProcessAlternation extends ProcessComposite {
  public ProcessAlternation(String name) {
    super(name);
  }

  public ProcessAlternation(String name, ProcessComponent[] subprocesses) {
    super(name, subprocesses);
  }

  public ProcessAlternation(String name, List subprocesses) {
    super(name, subprocesses);
  }

  public void accept(ProcessVisitor v) {
    v.visit(this);
  }
}
