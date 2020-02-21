package com.oozinoz.machine;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MachineComposite extends MachineComponent {
  protected List components = new ArrayList();

  public MachineComposite(int id) {
    this(id, null);
  }

  public MachineComposite(int id, MachineComponent parent) {
    this(id, parent, (Engineer) null);
  }

  public MachineComposite(int id, MachineComponent parent, Engineer responsible) {
    super(id, parent, responsible);
  }

  public MachineComposite(int id, MachineComponent parent,
    MachineComponent[] components) {
    super(id, parent);
    for(int i = 0; i < components.length; i++) {
      add(components[i]);
    }
  }

  public int getMachineCount() {
    int count = 0;
    Iterator i = components.iterator();
    while(i.hasNext()) {
      MachineComponent mc = (MachineComponent) i.next();
      count += mc.getMachineCount();
    }
    return count;
  }

  public void add(MachineComponent component) {
    components.add(component);
  }

  public void add(MachineComponent[] children) {
    for(int i = 0; i < children.length; i++) {
      components.add(children[i]);
    }
  }

  public void accept(MachineVisitor v) {
    v.visit(this);
  }

  public List getComponents() {
    return components;
  }

  protected boolean isTree(Set visited) {
    visited.add(this);
    Iterator i = components.iterator();
    while(i.hasNext()) {
      MachineComponent c = (MachineComponent) i.next();
      if(visited.contains(c) || !c.isTree(visited))
        return false;
    }
    return true;
  }

  public MachineComponent find(int thatId) {
    if(id == thatId)
      return this;

    List components = getComponents();

    for(int i = 0; i < components.size(); i++) {
      MachineComponent child = (MachineComponent) components.get(i);
      MachineComponent mc = child.find(thatId);
      if(mc != null)
        return mc;
    }
    return null;
  }

  public MachineComponent find(String name) {
    if(name.equals(this.toString()))
      return this;

    List components = getComponents();
    for(int i = 0; i < components.size(); i++) {
      MachineComponent child = (MachineComponent) components.get(i);
      MachineComponent mc = child.find(name);
      if(mc != null)
        return mc;
    }
    return null;
  }

  public ComponentIterator iterator(Set visited) {
    return new CompositeIterator(this, components, visited);
  }
}
