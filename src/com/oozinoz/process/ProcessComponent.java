package com.oozinoz.process;

import com.oozinoz.iterator.ComponentIterator;

import java.util.HashSet;
import java.util.Set;

public abstract class ProcessComponent {
  protected String name;

  public ProcessComponent(String name) {
    this.name = name;
  }

  public abstract void accept(ProcessVisitor v);

  public String getName() {
    return name;
  }

  public ComponentIterator iterator() {
    return iterator(new HashSet());
  }

  public abstract ComponentIterator iterator(Set visited);

  public int getStepCount() {
    return getStepCount(new HashSet());
  }

  public abstract int getStepCount(Set visited);

  public String toString() {
    return name;
  }
}
