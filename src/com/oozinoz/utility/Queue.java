package com.oozinoz.utility;

import java.util.ArrayList;

public class Queue {
  private ArrayList queue;

  public Queue() {
    queue = new ArrayList();
  }

  public void enqueue(Object obj) {
    queue.add(obj);
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public Object dequeue() {
    Object result = queue.get(0);
    queue.remove(0);
    return result;
  }

  public int size() {
    return queue.size();
  }
}
