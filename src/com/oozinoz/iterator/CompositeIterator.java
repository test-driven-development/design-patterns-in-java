package com.oozinoz.iterator;

import com.oozinoz.process.ProcessComponent;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CompositeIterator extends ComponentIterator {
  protected Object peek;
  protected Iterator children;
  protected ComponentIterator subiterator;

  public CompositeIterator(Object head, List components, Set visited) {
    super(head, visited);
    children = components.iterator();
  }

  public int getDepth() {
    if(subiterator != null)
      return subiterator.getDepth() + 1;
    return 0;
  }

  public boolean hasNext() {
    if(peek == null)
      peek = next();
    return peek != null;
  }

  public Object next() {
    if(peek != null) {
      Object result = peek;
      peek = null;
      return result;
    }

    if(!visited.contains(head)) {
      visited.add(head);
      if(shouldShowInterior())
        return head;
    }

    return nextDescendant();
  }

  protected Object nextDescendant() {
    while(true) {
      if(subiterator != null) {
        if(subiterator.hasNext())
          return subiterator.next();
      }

      if(!children.hasNext())
        return null;

      ProcessComponent pc = (ProcessComponent) children.next();
      if(!visited.contains(pc)) {
        subiterator = pc.iterator(visited);
        subiterator.setShowInterior(shouldShowInterior());
      }
    }
  }
}
