package com.oozinoz.process;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.iterator.LeafIterator;

import java.util.Set;

public class ProcessStep extends ProcessComponent {
  public ProcessStep(String name) {
    super(name);
  }

  public void accept(ProcessVisitor v) {
    v.visit(this);
  }

  public ComponentIterator iterator(Set visited) {
    return new LeafIterator(this, visited);
  }

  public int getStepCount(Set visited) {
    visited.add(name);
    return 1;
  }
}
