package com.oozinoz.process;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class ProcessComposite extends ProcessComponent {
  protected List subprocesses;

  public ProcessComposite(String name) {
    this(name, new ArrayList());
  }

  public ProcessComposite(String name, ProcessComponent[] existingProcesses) {
    super(name);
    subprocesses = new ArrayList();
    for(int i = 0; i < existingProcesses.length; i++) {
      subprocesses.add(existingProcesses[i]);
    }
  }

  public ProcessComposite(String name, List subprocesses) {
    super(name);
    this.subprocesses = subprocesses;
  }

  public List getChildren() {
    return subprocesses;
  }

  public void add(ProcessComponent c) {
    subprocesses.add(c);
  }

  public ComponentIterator iterator(Set visited) {
    return new CompositeIterator(this, subprocesses, visited);
  }

  public int getStepCount(Set visited) {
    visited.add(getName());
    int count = 0;
    for(int i = 0; i < subprocesses.size(); i++) {
      ProcessComponent pc = (ProcessComponent) subprocesses.get(i);
      if(!visited.contains(pc.getName()))
        count += pc.getStepCount(visited);
    }
    return count;
  }
}
