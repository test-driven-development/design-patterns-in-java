package com.oozinoz.iterator;

import java.util.Iterator;
import java.util.Set;

public abstract class ComponentIterator implements Iterator {
  protected Object head;

  protected Set visited;

  protected boolean returnInterior = true;

  public ComponentIterator(Object head, Set visited) {
    this.head = head;
    this.visited = visited;
  }

  public boolean shouldShowInterior() {
    return returnInterior;
  }

  public void setShowInterior(boolean value) {
    returnInterior = value;
  }

  public abstract int getDepth();

  public void remove() {
    throw new UnsupportedOperationException("ComponentIterator.Remove");
  }
}
