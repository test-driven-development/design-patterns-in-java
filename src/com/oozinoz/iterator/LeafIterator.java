package com.oozinoz.iterator;

import java.util.Set;

public class LeafIterator extends ComponentIterator {
  public LeafIterator(Object head, Set visited) {
    super(head, visited);
  }

  public int getDepth() {
    return 0;
  }

  public boolean hasNext() {
    return !visited.contains(head);
  }

  public Object next() {
    if(visited.contains(head))
      return null;

    visited.add(head);
    return head;
  }

}
