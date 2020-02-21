package com.oozinoz.machine;

import com.oozinoz.iterator.ComponentIterator;

import java.util.HashSet;
import java.util.Set;

public abstract class MachineComponent {
  protected int id = 0;
  protected String name;
  protected MachineComponent parent;
  protected Engineer responsible;

  protected MachineComponent(int id) {
    this(id, null);
  }

  protected MachineComponent(int id, MachineComponent parent) {
    this(id, parent, null);
  }

  protected MachineComponent(int id, MachineComponent parent, Engineer responsible) {
    this.id = id;
    this.parent = parent;
    this.responsible = responsible;
  }

  public abstract void accept(MachineVisitor visitor);

  public abstract int getMachineCount();

  protected abstract boolean isTree(Set s);

  public boolean isTree() {
    return isTree(new HashSet());
  }

  public ComponentIterator iterator() {
    return iterator(new HashSet());
  }

  public abstract ComponentIterator iterator(Set set);

  public String toString() {
    if(name != null) {
      return name;
    }
    String s = getClass().getName();
    return s.substring(s.lastIndexOf('.') + 1) + ":" + id;
  }

  public boolean equals(Object o) {
    if(o == this)
      return true;
    if(!(o instanceof MachineComponent))
      return false;
    MachineComponent mc = (MachineComponent) o;
    return id == mc.id;
  }

  public Engineer getResponsible() {
    if(responsible != null)
      return responsible;

    if(parent != null)
      return parent.getResponsible();

    return null;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MachineComponent getParent() {
    return parent;
  }

  public MachineComponent find(int thatId) {
    if(id == thatId)
      return this;
    return null;
  }

  public MachineComponent find(String name) {
    if(this.toString().equals(name))
      return this;
    return null;
  }
}
