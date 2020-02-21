package com.oozinoz.process;

import java.util.List;

public class ProcessSequence extends ProcessComposite {
  public ProcessSequence(String name) {
    super(name);
  }

  public ProcessSequence(String name, ProcessComponent[] subprocesses) {
    super(name, subprocesses);
  }

  public ProcessSequence(String name, List subprocesses) {
    super(name, subprocesses);
  }

  public void accept(ProcessVisitor v) {
    v.visit(this);
  }
}
